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
    collectionResourceRel = "bookReports",
    path = "bookReports"
)
public interface BookReportRepository
    extends PagingAndSortingRepository<BookReport, Long> {
    @Query(
        value = "select bookReport " +
        "from BookReport bookReport " +
        "where(:reportId is null or bookReport.reportId = :reportId)"
    )
    BookReport bookReportDetails(Long reportId);

    @Query(
        value = "select bookReport " +
        "from BookReport bookReport " +
        "where(:bookId is null or bookReport.bookId = :bookId) and (:reporterId is null or bookReport.reporterId = :reporterId) and (:status is null or bookReport.status = :status) and (:reportedAtFrom is null or bookReport.reportedAtFrom = :reportedAtFrom) and (:reportedAtTo is null or bookReport.reportedAtTo = :reportedAtTo) and (:page is null or bookReport.page = :page) and (:size is null or bookReport.size = :size)"
    )
    List<BookReport> bookReportList(
        BookId bookId,
        Long reporterId,
        ReportStatus status,
        Date reportedAtFrom,
        Date reportedAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
