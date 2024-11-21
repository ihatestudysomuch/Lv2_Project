package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "detections",
    path = "detections"
)
public interface DetectionRepository
    extends PagingAndSortingRepository<Detection, Long> {

    Optional<Detection> findByNewsId(Long id);
}
