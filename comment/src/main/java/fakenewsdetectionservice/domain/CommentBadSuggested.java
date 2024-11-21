package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentBadSuggested extends AbstractEvent {

    private Long id;
    private String user;
    private String commentContent;
    private String boardId;
    private String likeCount;
    private String badCount;

    public CommentBadSuggested(Comment aggregate) {
        super(aggregate);
    }

    public CommentBadSuggested() {
        super();
    }
}
//>>> DDD / Domain Event
