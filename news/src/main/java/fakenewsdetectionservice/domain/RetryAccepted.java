package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import lombok.Data;
import lombok.ToString;

//<<< DDD / Domain Event
@Data
@ToString
public class RetryAccepted extends AbstractEvent {

    private Long id;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String status;
    private String user;

    public RetryAccepted(News aggregate) {
        super(aggregate);
    }

    public RetryAccepted() {
        super();
    }
}
//>>> DDD / Domain Event