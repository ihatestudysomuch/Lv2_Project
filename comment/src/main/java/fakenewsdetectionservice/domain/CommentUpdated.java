package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentUpdated extends AbstractEvent {

    private Long id;
    private String user;
    private String commentContent;
    private String boardId;
    private String likeCount;
    private String badCount;

    public CommentUpdated(Comment aggregate) {
        super(aggregate);
    }

    public CommentUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
