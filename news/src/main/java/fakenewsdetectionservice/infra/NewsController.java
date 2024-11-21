package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/news")
@Transactional
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    // upload command
//    http POST localhost:8080/news
//    newsTitle="value"
//    newsSubTitle="value"
//    newsContent="value"
//    status="value"
//    user="value"

    @RequestMapping(
            value = "/news/upload",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    public News upload(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody News news
    ) throws Exception {
        System.out.println("##### /news/upload  called #####");
        // RequesBody로 New를 전달하고 status는 자동으로 upload 성공하면 "뉴스 업로드 완료"로 설정
//        News news = new News();
        news.upload();
        newsRepository.save(news);
        return news;
    }

    // cancel command
//    http DELETE localhost:8080/news/1
}
//>>> Clean Arch / Inbound Adaptor
