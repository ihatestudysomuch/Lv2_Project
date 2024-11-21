package fakenewsdetectionservice.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fakenewsdetectionservice.config.kafka.KafkaProcessor;
import fakenewsdetectionservice.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AnalysisRepository analysisRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='NewsUploaded'"
    )
    public void wheneverNewsUploaded_Analyze(
        @Payload NewsUploaded newsUploaded
    ) {
        NewsUploaded event = newsUploaded;
        System.out.println(
            "\n\n##### listener Analyze : " + newsUploaded + "\n\n"
        );

        // Sample Logic //
        Analysis.analyze(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
