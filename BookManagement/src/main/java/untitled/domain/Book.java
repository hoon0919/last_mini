package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.BookManagementApplication;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String title;

    private BookStatus status;

    private BookVisibility visibility;

    private String reportedReason;

    private Date createdAt;

    @Embedded
    private AuthorId authorId;

    public static BookRepository repository() {
        BookRepository bookRepository = BookManagementApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public void reviewBook(ReviewBookCommand reviewBookCommand) {
        //implement business logic here:

        BookReviewed bookReviewed = new BookReviewed(this);
        bookReviewed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void setBookHidden(SetBookHiddenCommand setBookHiddenCommand) {
        //implement business logic here:

        BookSetHidden bookSetHidden = new BookSetHidden(this);
        bookSetHidden.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
