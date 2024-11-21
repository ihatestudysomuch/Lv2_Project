package fakenewsdetectionservice.domain;

import lombok.Data;

@Data
public class WriteCommand {

    private Long id;
    private String user;
    private String commentContent;
    private Long boardId;
}
