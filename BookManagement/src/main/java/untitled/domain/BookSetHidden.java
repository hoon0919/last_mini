package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookSetHidden extends AbstractEvent {

    private Long bookId;
    private String hiddenReason;
    private BookStatus status;
    private BookVisibility visibility;

    public BookSetHidden(Book aggregate) {
        super(aggregate);
    }

    public BookSetHidden() {
        super();
    }
}
//>>> DDD / Domain Event
