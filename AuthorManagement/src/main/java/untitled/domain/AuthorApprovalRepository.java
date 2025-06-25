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
    collectionResourceRel = "authorApprovals",
    path = "authorApprovals"
)
public interface AuthorApprovalRepository
    extends PagingAndSortingRepository<AuthorApproval, Long> {
    @Query(
        value = "select authorApproval " +
        "from AuthorApproval authorApproval " +
        "where(:approvalId is null or authorApproval.approvalId = :approvalId)"
    )
    AuthorApproval authorApprovalDetails(Long approvalId);

    @Query(
        value = "select authorApproval " +
        "from AuthorApproval authorApproval " +
        "where(:decision is null or authorApproval.decision = :decision) and (:decidedAtFrom is null or authorApproval.decidedAtFrom = :decidedAtFrom) and (:decidedAtTo is null or authorApproval.decidedAtTo = :decidedAtTo) and (:page is null or authorApproval.page = :page) and (:size is null or authorApproval.size = :size)"
    )
    List<AuthorApproval> authorApprovalList(
        ApprovalDecision decision,
        Date decidedAtFrom,
        Date decidedAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
