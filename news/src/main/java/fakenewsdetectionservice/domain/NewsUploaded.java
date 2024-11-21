package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class NewsUploaded extends AbstractEvent {

    private Long id;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String status;
    private String user;

    public NewsUploaded(News aggregate) {
        super(aggregate);
    }

    public NewsUploaded() {
        super();
    }
}
//>>> DDD / Domain Event
