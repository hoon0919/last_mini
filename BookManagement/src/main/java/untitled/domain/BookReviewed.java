package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookReviewed extends AbstractEvent {

    private Long bookId;
    private String reviewComment;
    private BookStatus status;
    private BookVisibility visibility;

    public BookReviewed(Book aggregate) {
        super(aggregate);
    }

    public BookReviewed() {
        super();
    }
}
//>>> DDD / Domain Event
