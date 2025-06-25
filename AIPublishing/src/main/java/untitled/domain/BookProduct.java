package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AiPublishingApplication;

@Entity
@Table(name = "BookProduct_table")
@Data
//<<< DDD / Aggregate Root
public class BookProduct {

    @Id
    private String productId;

    private Date registrationDate;

    @Embedded
    private PublishingJobId publishingJobId;

    public static BookProductRepository repository() {
        BookProductRepository bookProductRepository = AiPublishingApplication.applicationContext.getBean(
            BookProductRepository.class
        );
        return bookProductRepository;
    }

    //<<< Clean Arch / Port Method
    public void createBookProduct(
        CreateBookProductCommand createBookProductCommand
    ) {
        //implement business logic here:

        BookProductCreationFailed bookProductCreationFailed = new BookProductCreationFailed(
            this
        );
        bookProductCreationFailed.publishAfterCommit();
        BookProductCreated bookProductCreated = new BookProductCreated(this);
        bookProductCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
