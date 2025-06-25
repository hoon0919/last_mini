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
@Table(name = "BookReport_table")
@Data
//<<< DDD / Aggregate Root
public class BookReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reportId;

    private Long reporterId;

    private String reason;

    private Date reportedAt;

    private ReportStatus status;

    @Embedded
    private BookId bookId;

    public static BookReportRepository repository() {
        BookReportRepository bookReportRepository = BookManagementApplication.applicationContext.getBean(
            BookReportRepository.class
        );
        return bookReportRepository;
    }

    //<<< Clean Arch / Port Method
    public void createBookReport(
        CreateBookReportCommand createBookReportCommand
    ) {
        //implement business logic here:

        BookReported bookReported = new BookReported(this);
        bookReported.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
