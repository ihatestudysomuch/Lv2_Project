package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CommentWrited extends AbstractEvent {

    private Long id;
    private String boardId;
    private String user;
    private String commentContent;
    private String likeCount;
    private String badCount;
}
