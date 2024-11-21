package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CommentCounted extends AbstractEvent {

    private Long id;
    private Long newsId;
    private Integer commentCount;
    private String user;
    private String status;

    public CommentCounted(Boards aggregate) {
        super(aggregate);
    }

    public CommentCounted() {
        super();
    }
}
//>>> DDD / Domain Event
