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
    collectionResourceRel = "publishingJobs",
    path = "publishingJobs"
)
public interface PublishingJobRepository
    extends PagingAndSortingRepository<PublishingJob, String> {
    @Query(
        value = "select publishingJob " +
        "from PublishingJob publishingJob " +
        "where(:authorId is null or publishingJob.authorId = :authorId) and (:status is null or publishingJob.status = :status) and (:requestedAtFrom is null or publishingJob.requestedAtFrom = :requestedAtFrom) and (:requestedAtTo is null or publishingJob.requestedAtTo = :requestedAtTo) and (:page is null or publishingJob.page = :page) and (:size is null or publishingJob.size = :size)"
    )
    List<PublishingJob> publishingJobStatusList(
        AuthorId authorId,
        PublishingJobStatus status,
        Date requestedAtFrom,
        Date requestedAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select publishingJob " +
        "from PublishingJob publishingJob " +
        "where(:publishingJobId is null or publishingJob.publishingJobId like %:publishingJobId%)"
    )
    PublishingJob publishingJobDetails(String publishingJobId);
}
