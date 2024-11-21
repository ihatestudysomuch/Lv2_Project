package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BadSuggested extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String status;
    private String commentCount;
    private String likeCount;
    private String badCount;
    private String result;
    private String ratio;
    private String user;

    public BadSuggested(Boards aggregate) {
        super(aggregate);
    }

    public BadSuggested() {
        super();
    }
}
//>>> DDD / Domain Event
