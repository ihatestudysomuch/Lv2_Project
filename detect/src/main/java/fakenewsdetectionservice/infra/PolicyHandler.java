package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.config.kafka.KafkaProcessor;
import fakenewsdetectionservice.domain.AnalysisCompleted;
import fakenewsdetectionservice.domain.AnalysisPaused;
import fakenewsdetectionservice.domain.Detection;
import fakenewsdetectionservice.domain.DetectionRepository;
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
    DetectionRepository detectionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AnalysisCompleted'"
    )
    public void wheneverAnalysisCompleted_Success(
        @Payload AnalysisCompleted analysisCompleted
    ) {
        AnalysisCompleted event = analysisCompleted;
        System.out.println(
            "\n\n##### listener Success : " + analysisCompleted + "\n\n"
        );

        // Sample Logic //
        Detection.success(event);
    }

    @StreamListener(
            value = KafkaProcessor.INPUT,
            condition = "headers['type']=='AnalysisPaused'"
    )
    public void wheneverAnalysisPaused_Fail(
            @Payload AnalysisPaused analysisPaused
    ) {
        AnalysisPaused event = analysisPaused;
        System.out.println(
                "\n\n##### listener Fail : " + analysisPaused + "\n\n"
        );

        // Sample Logic //
        Detection.fail(event);
    }
}

//>>> Clean Arch / Inbound Adaptor
