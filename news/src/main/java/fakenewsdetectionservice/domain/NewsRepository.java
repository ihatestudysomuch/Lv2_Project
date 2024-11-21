package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "news", path = "news")
public interface NewsRepository
    extends PagingAndSortingRepository<News, Long> {}
