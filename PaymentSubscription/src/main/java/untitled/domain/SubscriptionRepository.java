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
    collectionResourceRel = "subscriptions",
    path = "subscriptions"
)
public interface SubscriptionRepository
    extends PagingAndSortingRepository<Subscription, String> {
    @Query(
        value = "select subscription " +
        "from Subscription subscription " +
        "where(:subscriptionId is null or subscription.subscriptionId like %:subscriptionId%)"
    )
    Subscription subscriptionDetails(String subscriptionId);

    @Query(
        value = "select subscription " +
        "from Subscription subscription " +
        "where(:subscriberId is null or subscription.subscriberId = :subscriberId) and (:status is null or subscription.status = :status) and (:planType is null or subscription.planType = :planType) and (:startDateFrom is null or subscription.startDateFrom = :startDateFrom) and (:startDateTo is null or subscription.startDateTo = :startDateTo) and (:page is null or subscription.page = :page) and (:size is null or subscription.size = :size)"
    )
    List<Subscription> subscriptionList(
        SubscriberId subscriberId,
        SubscriptionStatus status,
        PlanType planType,
        Date startDateFrom,
        Date startDateTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
