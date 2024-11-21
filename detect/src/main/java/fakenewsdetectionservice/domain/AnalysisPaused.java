package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import lombok.Data;
import lombok.ToString;

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
}

