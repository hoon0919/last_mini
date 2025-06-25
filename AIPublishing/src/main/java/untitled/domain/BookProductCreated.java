package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookProductCreated extends AbstractEvent {

    private String productId;
    private PublishingJobId publishingJobId;
    private Date registrationDate;

    public BookProductCreated(BookProduct aggregate) {
        super(aggregate);
    }

    public BookProductCreated() {
        super();
    }
}
//>>> DDD / Domain Event
