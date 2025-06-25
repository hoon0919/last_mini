package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "manuscripts",
    path = "manuscripts"
)
public interface ManuscriptRepository
    extends PagingAndSortingRepository<Manuscript, Long> {
    @Query(
        value = "select manuscript " +
        "from Manuscript manuscript " +
        "where(:manuscriptId is null or manuscript.manuscriptId = :manuscriptId) and (:status is null or manuscript.status = :status) and (:publishedAt is null or manuscript.publishedAt = :publishedAt) and (:page is null or manuscript.page = :page) and (:size is null or manuscript.size = :size)"
    )
    List<Manuscript> publishingStatus(
        Long manuscriptId,
        ManuscriptStatus status,
        Date publishedAt,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select manuscript " +
        "from Manuscript manuscript " +
        "where(:authorId is null or manuscript.authorId = :authorId) and (:status is null or manuscript.status = :status) and (:createdAtFrom is null or manuscript.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or manuscript.createdAtTo = :createdAtTo) and (:page is null or manuscript.page = :page) and (:size is null or manuscript.size = :size)"
    )
    List<Manuscript> manuscriptList(
        AuthorId authorId,
        ManuscriptStatus status,
        Date createdAtFrom,
        Date createdAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select manuscript " +
        "from Manuscript manuscript " +
        "where(:manuscriptId is null or manuscript.manuscriptId = :manuscriptId)"
    )
    Manuscript manuscriptDetails(Long manuscriptId);
}
