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
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CommentWrited'"
    )
    public void wheneverCommentWrited_Notifiy(
        @Payload CommentWrited commentWrited
    ) {
        CommentWrited event = commentWrited;
        System.out.println(
            "\n\n##### listener Notifiy : " + commentWrited + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LikeSuggested'"
    )
    public void wheneverLikeSuggested_Notifiy(
        @Payload LikeSuggested likeSuggested
    ) {
        LikeSuggested event = likeSuggested;
        System.out.println(
            "\n\n##### listener Notifiy : " + likeSuggested + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BadSuggested'"
    )
    public void wheneverBadSuggested_Notifiy(
        @Payload BadSuggested badSuggested
    ) {
        BadSuggested event = badSuggested;
        System.out.println(
            "\n\n##### listener Notifiy : " + badSuggested + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DetetionFailed'"
    )
    public void wheneverDetetionFailed_Notifiy(
        @Payload DetetionFailed detetionFailed
    ) {
        DetetionFailed event = detetionFailed;
        System.out.println(
            "\n\n##### listener Notifiy : " + detetionFailed + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DetectionSucceeded'"
    )
    public void wheneverDetectionSucceeded_Notifiy(
        @Payload DetectionSucceeded detectionSucceeded
    ) {
        DetectionSucceeded event = detectionSucceeded;
        System.out.println(
            "\n\n##### listener Notifiy : " + detectionSucceeded + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CommentDeleted'"
    )
    public void wheneverCommentDeleted_Notifiy(
        @Payload CommentDeleted commentDeleted
    ) {
        CommentDeleted event = commentDeleted;
        System.out.println(
            "\n\n##### listener Notifiy : " + commentDeleted + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CommentUpdated'"
    )
    public void wheneverCommentUpdated_Notifiy(
        @Payload CommentUpdated commentUpdated
    ) {
        CommentUpdated event = commentUpdated;
        System.out.println(
            "\n\n##### listener Notifiy : " + commentUpdated + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CommentLikeSuggested'"
    )
    public void wheneverCommentLikeSuggested_Notifiy(
        @Payload CommentLikeSuggested commentLikeSuggested
    ) {
        CommentLikeSuggested event = commentLikeSuggested;
        System.out.println(
            "\n\n##### listener Notifiy : " + commentLikeSuggested + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CommentBadSuggested'"
    )
    public void wheneverCommentBadSuggested_Notifiy(
        @Payload CommentBadSuggested commentBadSuggested
    ) {
        CommentBadSuggested event = commentBadSuggested;
        System.out.println(
            "\n\n##### listener Notifiy : " + commentBadSuggested + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BoardRegistered'"
    )
    public void wheneverBoardRegistered_Notifiy(
        @Payload BoardRegistered boardRegistered
    ) {
        BoardRegistered event = boardRegistered;
        System.out.println(
            "\n\n##### listener Notifiy : " + boardRegistered + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BoardReject'"
    )
    public void wheneverBoardReject_Notifiy(@Payload BoardReject boardReject) {
        BoardReject event = boardReject;
        System.out.println(
            "\n\n##### listener Notifiy : " + boardReject + "\n\n"
        );

        // Sample Logic //
        Notification.notifiy(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
