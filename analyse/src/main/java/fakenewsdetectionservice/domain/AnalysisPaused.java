package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AnalysisPaused extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String status;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String progress;
    private String user;

    public AnalysisPaused(Analysis aggregate) {
        super(aggregate);
    }

    public AnalysisPaused() {
        super();
    }
}
//>>> DDD / Domain Event
