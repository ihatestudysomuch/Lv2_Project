package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DetetionFailed extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String ratio;
    private String status;
    private String result;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String user;
}
