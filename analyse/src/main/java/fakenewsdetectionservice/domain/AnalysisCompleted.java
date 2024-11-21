package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AnalysisCompleted extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String status;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    // 진행 상황 progress를 어떻게 알릴지 잘 모르겠음
    private String progress;
    private String user;

    public AnalysisCompleted(Analysis aggregate) {
        super(aggregate);
    }

    public AnalysisCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
