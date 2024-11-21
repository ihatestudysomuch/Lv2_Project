package fakenewsdetectionservice.domain;

import fakenewsdetectionservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "boards", path = "boards")
public interface BoardsRepository
    extends PagingAndSortingRepository<Boards, Long> {
//    Optional<String> findByBoardId(String id);
}
