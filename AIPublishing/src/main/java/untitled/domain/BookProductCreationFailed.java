package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookProductCreationFailed extends AbstractEvent {

    private PublishingJobId publishingJobId;
    private String failReason;
    private Date occurredAt;

    public BookProductCreationFailed(BookProduct aggregate) {
        super(aggregate);
    }

    public BookProductCreationFailed() {
        super();
    }
}
//>>> DDD / Domain Event
