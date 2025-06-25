package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointGranted extends AbstractEvent {

    private String subscriberId;
    private PointTransactionType type;
    private Integer amount;
    private Date createdAt;

    public PointGranted(Subscriber aggregate) {
        super(aggregate);
    }

    public PointGranted() {
        super();
    }
}
//>>> DDD / Domain Event
