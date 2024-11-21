package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CommentUpdated extends AbstractEvent {

    private Long id;
    private String user;
    private String commentContent;
    private String boardId;
    private String likeCount;
    private String badCount;
}
