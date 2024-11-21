package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CommentBadSuggested extends AbstractEvent {

    private Long id;
    private String user;
    private String commentContent;
    private String boardId;
    private String likeCount;
    private String badCount;
}
