package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query(
        value = "select book " +
        "from Book book " +
        "where(:bookId is null or book.bookId = :bookId)"
    )
    Book bookAdminDetails(Long bookId);

    @Query(
        value = "select book " +
        "from Book book " +
        "where(:status is null or book.status = :status) and (:visibility is null or book.visibility = :visibility) and (:createdAtFrom is null or book.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or book.createdAtTo = :createdAtTo) and (:page is null or book.page = :page) and (:size is null or book.size = :size)"
    )
    List<Book> bookAdminList(
        BookStatus status,
        BookVisibility visibility,
        Date createdAtFrom,
        Date createdAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
