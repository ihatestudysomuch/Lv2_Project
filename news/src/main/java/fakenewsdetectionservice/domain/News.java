package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.NewsApplication;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "News_table")
@Data
//<<< DDD / Aggregate Root
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String newsTitle;

    private String newsSubTitle;

    private String newsContent;

    private String status;

    private String user;

    @PostPersist
    public void onPostPersist() {
        NewsUploaded newsUploaded = new NewsUploaded(this);
        newsUploaded.publishAfterCommit();

        NewsCancelled newsCancelled = new NewsCancelled(this);
        newsCancelled.publishAfterCommit();
    }

    public static NewsRepository repository() {
        NewsRepository newsRepository = NewsApplication.applicationContext.getBean(
            NewsRepository.class
        );
        return newsRepository;
    }

    //<<< Clean Arch / Port Method
    public void upload() {
        //implement business logic here:
        setStatus("뉴스 업로드 완료");

        NewsUploaded newsUploaded = new NewsUploaded(this);
        newsUploaded.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void retry(DetetionFailed detetionFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        News news = new News();
        repository().save(news);

        NewsUploaded newsUploaded = new NewsUploaded(news);
        newsUploaded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(detetionFailed.get???()).ifPresent(news->{
            
            news // do something
            repository().save(news);

            NewsUploaded newsUploaded = new NewsUploaded(news);
            newsUploaded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void retry(AnalysisPaused analysisErrored) {
        //implement business logic here:

        /** Example 1:  new item
        News news = new News();
        repository().save(news);

        NewsUploaded newsUploaded = new NewsUploaded(news);
        newsUploaded.publishAfterCommit();
        */

        // Example 2:  finding and process

        repository().findById(analysisErrored.getNewsId()).ifPresent(news->{

            news.setStatus("뉴스를 다시 업로드 하세요.");
            repository().save(news);

            RetryAccepted retryAccepted = new RetryAccepted();
            retryAccepted.publishAfterCommit();

         });
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
