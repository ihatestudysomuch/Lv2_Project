package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class NewsCancelled extends AbstractEvent {

    private Long id;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String status;
    private String user;

    public NewsCancelled(News aggregate) {
        super(aggregate);
    }

    public NewsCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
