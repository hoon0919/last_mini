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
    collectionResourceRel = "bookProducts",
    path = "bookProducts"
)
public interface BookProductRepository
    extends PagingAndSortingRepository<BookProduct, String> {
    @Query(
        value = "select bookProduct " +
        "from BookProduct bookProduct " +
        "where(:publishingJobId is null or bookProduct.publishingJobId = :publishingJobId) and (:registrationDateFrom is null or bookProduct.registrationDateFrom = :registrationDateFrom) and (:registrationDateTo is null or bookProduct.registrationDateTo = :registrationDateTo) and (:page is null or bookProduct.page = :page) and (:size is null or bookProduct.size = :size)"
    )
    List<BookProduct> bookProductList(
        PublishingJobId publishingJobId,
        Date registrationDateFrom,
        Date registrationDateTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select bookProduct " +
        "from BookProduct bookProduct " +
        "where(:productId is null or bookProduct.productId like %:productId%) and (:publishingJobId is null or bookProduct.publishingJobId = :publishingJobId)"
    )
    BookProduct bookProductDetails(
        String productId,
        PublishingJobId publishingJobId
    );
}
