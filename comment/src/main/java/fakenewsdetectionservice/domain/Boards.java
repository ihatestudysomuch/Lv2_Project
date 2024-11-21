package fakenewsdetectionservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Boards_table")
@Data
//<<< DDD / Aggregate Root
public class Boards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long newsId;

    private String newsTitle;

    private String newsSubTitle;

    private String newsContent;

    private String status;

    private Integer commentCount;

    private Integer likeCount;

    private Integer badCount;

    private String result;

    private String ratio;

    private String user;

}
//>>> DDD / Aggregate Root
