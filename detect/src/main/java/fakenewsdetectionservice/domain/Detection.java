package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.DetectApplication;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Detection_table")
@Data
//<<< DDD / Aggregate Root
public class Detection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long newsId;

    private String ratio;

    private String status;

    private String result;

    private String newsTitle;

    private String newsSubTitle;

    private String newsContent;

    private String user;

    @PostPersist
    public void onPostPersist() {
        DetectionFailed detectionFailed = new DetectionFailed(this);
        detectionFailed.publishAfterCommit();
    }

    public static DetectionRepository repository() {
        DetectionRepository detectionRepository = DetectApplication.applicationContext.getBean(
            DetectionRepository.class
        );
        return detectionRepository;
    }

    //<<< Clean Arch / Port Method
    public static void success(AnalysisCompleted analysisCompleted) {
        //implement business logic here:

        if (analysisCompleted.getStatus().equals("분석 완료")) {
            // Example 1:  new item
            Detection detection = new Detection();

            detection.setNewsId(analysisCompleted.getNewsId());
            detection.setNewsTitle(analysisCompleted.getNewsTitle());
            detection.setNewsSubTitle(analysisCompleted.getNewsSubTitle());
            detection.setNewsContent(analysisCompleted.getNewsContent());
            detection.setUser(analysisCompleted.getUser());

            // After doing machine learning, 현재는 임의로 대답
            detection.setStatus("판별 완료");
            detection.setRatio("80%");
            detection.setResult("낚시성 기사(가짜 뉴스)");

            repository().save(detection);

            // 여기서 register의 가져올 정보 생성
            DetectionSucceeded detectionSucceeded = new DetectionSucceeded(detection);
            detectionSucceeded.publishAfterCommit();
        }



        /** Example 2:  finding and process
        
        repository().findById(analysisCompleted.get???()).ifPresent(detection->{
            
            detection // do something
            repository().save(detection);

            DetectionSucceeded detectionSucceeded = new DetectionSucceeded(detection);
            detectionSucceeded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

    // fail을 어떻게 해야 할지 잘 모르겠음...
    public static void fail(AnalysisPaused analysisPaused) {
        //implement business logic here:

        /** Example 1:  new item
         Detection detection = new Detection();
         repository().save(detection);

         DetetionFailed detetionFailed = new DetetionFailed(detection);
         detetionFailed.publishAfterCommit();
         */

        // Example 2:  finding and process

         repository().findByNewsId(analysisPaused.getNewsId()).ifPresent(detection->{

         detection.setStatus("판독 실패");
         detection.setResult("판독 실패");
         detection.setRatio("판독 실패");

         repository().save(detection);

         DetectionFailed detectionFailed = new DetectionFailed(detection);
         detectionFailed.publishAfterCommit();

         });


    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
