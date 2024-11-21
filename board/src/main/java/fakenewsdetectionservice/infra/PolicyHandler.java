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
    BoardsRepository boardsRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
            value = KafkaProcessor.INPUT,
            condition = "headers['type']=='DetectionSucceeded'"
    )
    public void wheneverDetectionSucceeded_Register(
            @Payload DetectionSucceeded detectionSucceeded
    ) {
        DetectionSucceeded event = detectionSucceeded;
        System.out.println(
                "\n\n##### listener Register : " + detectionSucceeded + "\n\n"
        );

        // Sample Logic //
        Boards.register(event);
    }

    @StreamListener(
            value = KafkaProcessor.INPUT,
            condition = "headers['type']=='CommentWrited'"
    )
    public void wheneverCommentWrited_Count(
            @Payload CommentWrited commentWrited
    ) {
        CommentWrited event = commentWrited;
        System.out.println(
                "\n\n##### listener Count : " + commentWrited + "\n\n"
        );

        // Sample Logic //
        Boards.count(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
