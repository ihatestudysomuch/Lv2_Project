package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.config.kafka.KafkaProcessor;
import fakenewsdetectionservice.domain.AnalysisPaused;
import fakenewsdetectionservice.domain.DetetionFailed;
import fakenewsdetectionservice.domain.News;
import fakenewsdetectionservice.domain.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NewsRepository newsRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DetetionFailed'"
    )
    public void wheneverDetetionFailed_Retry(
        @Payload DetetionFailed detetionFailed
    ) {
        DetetionFailed event = detetionFailed;
        System.out.println(
            "\n\n##### listener Retry : " + detetionFailed + "\n\n"
        );

        // Sample Logic //
        News.retry(event);
    }

    @StreamListener(
            value = KafkaProcessor.INPUT,
            condition = "headers['type']=='AnalysisPaused'"
    )
    public void wheneverAnalysisPaused_Retry(
            @Payload AnalysisPaused analysisPaused
    ) {
        AnalysisPaused event = analysisPaused;
        System.out.println(
                "\n\n##### listener Retry : " + analysisPaused + "\n\n"
        );

        // Sample Logic //
        News.retry(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
