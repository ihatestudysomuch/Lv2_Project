package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class NewsUploaded extends AbstractEvent {

    private Long id;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String status;
    private String user;
}
