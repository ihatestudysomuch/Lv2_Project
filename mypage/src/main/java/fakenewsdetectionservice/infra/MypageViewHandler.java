package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import fakenewsdetectionservice.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {

//<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenNewsUploaded_then_CREATE_1 (@Payload NewsUploaded newsUploaded) {
        try {

            if (!newsUploaded.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setNewsTitle(newsUploaded.getNewsTitle());
            mypage.setStatus(판독할 뉴스 등록);
            mypage.setNewsId(newsUploaded.getId());
            mypage.setUser(newsUploaded.getUser());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDetectionSucceeded_then_CREATE_2 (@Payload DetectionSucceeded detectionSucceeded) {
        try {

            if (!detectionSucceeded.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setNewsTitle(detectionSucceeded.getNewsTitle());
            mypage.setNewsId(detectionSucceeded.getNewsId());
            mypage.setStatus(판독 완료);
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCommentWrited_then_CREATE_3 (@Payload CommentWrited commentWrited) {
        try {

            if (!commentWrited.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setUser(commentWrited.getUser());
            mypage.setBoardId(Long.valueOf(commentWrited.getBoardId()));
            mypage.setCommentContent(commentWrited.getCommentContent());
            mypage.setCommentId(commentWrited.getId());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBoardRegistered_then_CREATE_4 (@Payload BoardRegistered boardRegistered) {
        try {

            if (!boardRegistered.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setStatus(게시글이 등록되었습니다.);
            mypage.setNewsTitle(boardRegistered.getNewsTitle());
            mypage.setBoardId(boardRegistered.getId());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenLikeSuggested_then_CREATE_5 (@Payload LikeSuggested likeSuggested) {
        try {

            if (!likeSuggested.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setStatus(좋아요가 올라갔습니다);
            mypage.setBoardId(likeSuggested.getId());
            mypage.setCommentLikeCount(likeSuggested.getLikeCount());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCommentLikeSuggested_then_CREATE_6 (@Payload CommentLikeSuggested commentLikeSuggested) {
        try {

            if (!commentLikeSuggested.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setCommentId(commentLikeSuggested.getId());
            mypage.setStatus(댓글에 좋아요가 올라갔습니다);
            mypage.setLikeCount(commentLikeSuggested.getLikeCount());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCommentUpdated_then_UPDATE_1(@Payload CommentUpdated commentUpdated) {
        try {
            if (!commentUpdated.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByCommentContent(commentUpdated.getCommentContent());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setCommentId(commentUpdated.getId());
                    mypage.setStatus(댓글이 변경되었습니다.);
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCommentDeleted_then_DELETE_1(@Payload CommentDeleted commentDeleted) {
        try {
            if (!commentDeleted.validate()) return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//>>> DDD / CQRS
}

