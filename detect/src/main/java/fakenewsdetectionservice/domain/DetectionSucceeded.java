package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DetectionSucceeded extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String ratio;
    private String status;
    private String result;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String user;

    public DetectionSucceeded(Detection aggregate) {
        super(aggregate);
    }

    public DetectionSucceeded() {
        super();
    }
}
//>>> DDD / Domain Event
