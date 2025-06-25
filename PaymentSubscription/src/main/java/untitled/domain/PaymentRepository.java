package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "payments", path = "payments")
public interface PaymentRepository
    extends PagingAndSortingRepository<Payment, String> {
    @Query(
        value = "select payment " +
        "from Payment payment " +
        "where(:subscriberId is null or payment.subscriberId = :subscriberId) and (:status is null or payment.status = :status) and (:paymentMethod is null or payment.paymentMethod = :paymentMethod) and (:timestampFrom is null or payment.timestampFrom = :timestampFrom) and (:timestampTo is null or payment.timestampTo = :timestampTo) and (:page is null or payment.page = :page) and (:size is null or payment.size = :size)"
    )
    List<Payment> paymentHistory(
        SubscriberId subscriberId,
        PaymentStatus status,
        PaymentMethod paymentMethod,
        Date timestampFrom,
        Date timestampTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select payment " +
        "from Payment payment " +
        "where(:paymentId is null or payment.paymentId like %:paymentId%)"
    )
    Payment paymentDetails(String paymentId);
}
