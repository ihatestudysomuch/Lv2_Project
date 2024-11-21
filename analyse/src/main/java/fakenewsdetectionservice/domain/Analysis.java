package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.AnalyseApplication;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Analysis_table")
@Data
//<<< DDD / Aggregate Root
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long newsId;

    private String status;

    private String newsTitle;

    private String newsSubTitle;

    private String newsContent;

    private String progress;

    private String user;

    @PostPersist
    public void onPostPersist() {

    }

    public static AnalysisRepository repository() {
        AnalysisRepository analysisRepository = AnalyseApplication.applicationContext.getBean(
            AnalysisRepository.class
        );
        return analysisRepository;
    }

    //<<< Clean Arch / Port Method
    public static void analyze(NewsUploaded newsUploaded) {
        //implement business logic here:

        // Example 1:  new item
        // News에서 저장한 정보 그대로 status만 바꿔서 전달
        Analysis analysis = new Analysis();

        analysis.setNewsId(newsUploaded.getId());
        analysis.setNewsTitle(newsUploaded.getNewsTitle());
        analysis.setNewsSubTitle(newsUploaded.getNewsSubTitle());
        analysis.setNewsContent(newsUploaded.getNewsContent());
        analysis.setUser(newsUploaded.getUser());

        // After machine learning answer(임의값)
        if(newsUploaded.getId() % 2 == 0) {
            analysis.setProgress("진행률 25%");
            analysis.setStatus("분석 진행중");
        } else {
            analysis.setProgress("진행률 100%");
            analysis.setStatus("분석 완료");
        }
        
        repository().save(analysis);

        AnalysisCompleted analysisCompleted = new AnalysisCompleted(analysis);
        analysisCompleted.publishAfterCommit();

    }
    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public void pause() {
        //implement business logic here:
        setStatus("분석 취소, 재시도 하세요");

        // retry에 전달하기 위한 newsId 생성 후 전달
        AnalysisPaused analysisPaused = new AnalysisPaused(this);
        analysisPaused.setNewsId(this.getNewsId());
        analysisPaused.publishAfterCommit();

    };

    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
