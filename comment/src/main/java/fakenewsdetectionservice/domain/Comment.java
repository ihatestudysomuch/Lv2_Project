package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.CommentApplication;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Comment_table")
@Data
//<<< DDD / Aggregate Root
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user;

    private String commentContent;

    private Long boardId;

    private Integer likeCount;

    private Integer badCount;

    private String status;

    @PostPersist
    public void onPostPersist() {
        CommentWrited commentWrited = new CommentWrited(this);
        commentWrited.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        CommentsDeleted commentsDeleted = new CommentsDeleted(this);
        commentsDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        CommentsDeleted commentsDeleted = new CommentsDeleted(this);
        commentsDeleted.publishAfterCommit();
    }

    public static CommentRepository repository() {
        CommentRepository commentRepository = CommentApplication.applicationContext.getBean(
                CommentRepository.class
        );
        return commentRepository;
    }

    //<<< Clean Arch / Port Method
    public void write() {
        //implement business logic here:
        // 좋아요, 싫어요 수 0으로 set
        setLikeCount(0);
        setBadCount(0);
        setStatus("댓글 작성 완료");

        CommentWrited commentWrited = new CommentWrited(this);
        commentWrited.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void update(UpdateCommand updateCommand) {
        //implement business logic here:
        setStatus("댓글 수정 완료");
        setCommentContent(updateCommand.getCommentContent());

        CommentUpdated commentUpdated = new CommentUpdated(this);
        commentUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void likeCo() {
        //implement business logic here:
        setLikeCount(getLikeCount() + 1);

        CommentLikeSuggested commentLikeSuggested = new CommentLikeSuggested(this);
        commentLikeSuggested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void badCo() {
        //implement business logic here:
        setBadCount(getBadCount() + 1);

        CommentBadSuggested commentBadSuggested = new CommentBadSuggested(this);
        commentBadSuggested.publishAfterCommit();
    }


    //<<< Clean Arch / Port Method
    // BoardsRejected(삭제) -> 그에 포함된 댓글도 다 삭제되어야 함
    public static void commentsDelete(BoardRejected boardRejected) {
        //implement business logic here:

        /** Example 1:  new item
         Comment comment = new Comment();
         repository().save(comment);

         CommentsDeleted commentsDeleted = new CommentsDeleted(comment);
         commentsDeleted.publishAfterCommit();
         */

        // Example 2:  finding and process

         repository().findByBoardId(boardRejected.getId()).forEach(comment->{

         repository().delete(comment);

         CommentsDeleted commentsDeleted = new CommentsDeleted(comment);
         commentsDeleted.publishAfterCommit();

         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
