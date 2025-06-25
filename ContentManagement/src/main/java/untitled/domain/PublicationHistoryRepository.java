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
    collectionResourceRel = "publicationHistories",
    path = "publicationHistories"
)
public interface PublicationHistoryRepository
    extends PagingAndSortingRepository<PublicationHistory, Long> {
    @Query(
        value = "select publicationHistory " +
        "from PublicationHistory publicationHistory " +
        "where(:manuscriptId is null or publicationHistory.manuscriptId = :manuscriptId) and (:resultStatus is null or publicationHistory.resultStatus = :resultStatus) and (:requestedAtFrom is null or publicationHistory.requestedAtFrom = :requestedAtFrom) and (:requestedAtTo is null or publicationHistory.requestedAtTo = :requestedAtTo) and (:page is null or publicationHistory.page = :page) and (:size is null or publicationHistory.size = :size)"
    )
    List<PublicationHistory> publicationHistoryList(
        ManuscriptId manuscriptId,
        PublicationResultStatus resultStatus,
        Date requestedAtFrom,
        Date requestedAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select publicationHistory " +
        "from PublicationHistory publicationHistory " +
        "where(:publicationHistoryId is null or publicationHistory.publicationHistoryId = :publicationHistoryId)"
    )
    PublicationHistory publicationHistoryDetails(Long publicationHistoryId);
}
