package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DetectionFailed extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String ratio;
    private String status;
    private String result;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String user;

    public DetectionFailed(Detection aggregate) {
        super(aggregate);
    }

    public DetectionFailed() {
        super();
    }
}
//>>> DDD / Domain Event
