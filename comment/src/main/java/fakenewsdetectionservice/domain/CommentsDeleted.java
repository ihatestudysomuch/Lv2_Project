package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentsDeleted extends AbstractEvent {

    private Long id;
    private String user;
    private String commentContent;
    private String boardId;
    private String likeCount;
    private String badCount;

    public CommentsDeleted(Comment aggregate) {
        super(aggregate);
    }

    public CommentsDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
