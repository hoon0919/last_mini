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
    collectionResourceRel = "subscribers",
    path = "subscribers"
)
public interface SubscriberRepository
    extends PagingAndSortingRepository<Subscriber, String> {
    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId like %:subscriberId%)"
    )
    Subscriber subscriberDetails(String subscriberId);

    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId like %:subscriberId%) and (:type is null or subscriber.type = :type) and (:createdAtFrom is null or subscriber.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or subscriber.createdAtTo = :createdAtTo) and (:page is null or subscriber.page = :page) and (:size is null or subscriber.size = :size)"
    )
    List<Subscriber> pointTransactionHistory(
        String subscriberId,
        PointTransactionType type,
        Date createdAtFrom,
        Date createdAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId like %:subscriberId%)"
    )
    Subscriber pointExhaustedAlert(String subscriberId);
}
