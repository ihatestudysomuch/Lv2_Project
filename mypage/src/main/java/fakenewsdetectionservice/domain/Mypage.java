package fakenewsdetectionservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Mypage_table")
@Data
public class Mypage {

    private String newsTitle;
    private String status;
    private String user;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long newsId;

    private String commentContent;
    private Long boardId;
    private Long commentId;
    private Long id;
    private String result;
    private String ratio;
    private String newsSubTitle;
    private String newsContent;
    private String likeCount;
    private String commentLikeCount;
}
