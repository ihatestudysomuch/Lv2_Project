package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class NewsUploaded extends AbstractEvent {

    private Long id;
    private String newsTitle;
    private String newsSubTitle;
    private String newsContent;
    private String status;
    private String user;
}
