package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookReported extends AbstractEvent {

    private Long reportId;
    private BookId bookId;
    private Long reporterId;
    private String reason;
    private Date reportedAt;
    private ReportStatus status;

    public BookReported(BookReport aggregate) {
        super(aggregate);
    }

    public BookReported() {
        super();
    }
}
//>>> DDD / Domain Event
