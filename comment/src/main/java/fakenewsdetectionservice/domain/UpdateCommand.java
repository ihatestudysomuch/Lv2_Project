package fakenewsdetectionservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateCommand {

    private Long id;
    private String user;
    private String commentContent;
    private Integer likeCount;
    private Integer badCount;
    private String status;
}
