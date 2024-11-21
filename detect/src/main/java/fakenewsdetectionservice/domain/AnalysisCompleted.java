package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class AnalysisCompleted extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String status;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String progress;
    private String user;
}
