package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.BoardApplication;

import javax.persistence.*;
import lombok.Data;

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

    @PostPersist
    public void onPostPersist() {
        BoardRegistered boardRegistered = new BoardRegistered(this);
        boardRegistered.publishAfterCommit();

        CommentCounted commentCounted = new CommentCounted(this);
        commentCounted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static BoardsRepository repository() {
        BoardsRepository boardsRepository = BoardApplication.applicationContext.getBean(
                BoardsRepository.class
        );
        return boardsRepository;
    }


    //<<< Clean Arch / Port Method
    public static void register(DetectionSucceeded detectionSucceeded) {
        //implement business logic here:

        // Example 1:  new item
        Boards boards = new Boards();
        // Boards에서 News 관련 set을 하는 이유는 개인의 주관을 담는 것이 아닌,
        // 판독한 뉴스 정보, 결과를 올리는 곳이기 때문이다.
        boards.setNewsId(detectionSucceeded.getNewsId());
        boards.setNewsTitle(detectionSucceeded.getNewsTitle());
        boards.setNewsSubTitle(detectionSucceeded.getNewsSubTitle());
        boards.setNewsContent(detectionSucceeded.getNewsContent());
        boards.setStatus("게시글 업로드 완료");
        boards.setRatio(detectionSucceeded.getRatio());
        boards.setResult(detectionSucceeded.getResult());
        boards.setUser(detectionSucceeded.getUser());

        // 임의의 설정 값 (좋아요, 싫어요, 댓글 갯수)
        boards.setLikeCount(0);
        boards.setBadCount(0);
        boards.setCommentCount(0);

        repository().save(boards);

        BoardRegistered boardRegistered = new BoardRegistered(boards);
        boardRegistered.publishAfterCommit();


    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public void like() {
        //implement business logic here:
        // 좋아요 +1
        setLikeCount(getLikeCount() + 1);

        LikeSuggested likeSuggested = new LikeSuggested(this);
        likeSuggested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void bad() {
        //implement business logic here:
        // 싫어요 +1
        setBadCount(getBadCount() + 1);

        BadSuggested badSuggested = new BadSuggested(this);
        badSuggested.publishAfterCommit();
    }


    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void count(CommentWrited commentWrited) {
        //implement business logic here:

        /** Example 1:  new item
         Boards boards = new Boards();
         repository().save(boards);

         CommentCounted commentCounted = new CommentCounted(boards);
         commentCounted.publishAfterCommit();
         */

        // Example 2:  finding and process

         repository().findById(Long.valueOf(commentWrited.getBoardId())).ifPresent(boards->{
         // Boards의 댓글 수를 +1
         boards.setCommentCount(boards.getCommentCount() + 1);
         repository().save(boards);

         CommentCounted commentCounted = new CommentCounted(boards);
         commentCounted.publishAfterCommit();

         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
