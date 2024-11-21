package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class BoardRegistered extends AbstractEvent {

    private Long id;
    private Long newsId;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String status;
    private String commentCount;
    private String likeCount;
    private String badCount;
    private String result;
    private String ratio;
    private String user;
}
