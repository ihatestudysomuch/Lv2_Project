package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "analyses", path = "analyses")
public interface AnalysisRepository
    extends PagingAndSortingRepository<Analysis, Long> {
    Optional<Analysis> findByNewsId(Long id);
}
