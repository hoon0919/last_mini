package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository
    extends PagingAndSortingRepository<Author, Long> {
    @Query(
        value = "select author " +
        "from Author author " +
        "where(:authorId is null or author.authorId = :authorId)"
    )
    Author authorRegistrationDetails(Long authorId);

    @Query(
        value = "select author " +
        "from Author author " +
        "where(:registrationStatus is null or author.registrationStatus = :registrationStatus) and (:registeredAtFrom is null or author.registeredAtFrom = :registeredAtFrom) and (:registeredAtTo is null or author.registeredAtTo = :registeredAtTo) and (:page is null or author.page = :page) and (:size is null or author.size = :size)"
    )
    List<Author> authorRegistrationList(
        AuthorRegistrationStatus registrationStatus,
        Date registeredAtFrom,
        Date registeredAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
