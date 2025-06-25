package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointExhausted extends AbstractEvent {

    private String subscriberId;
    private Integer pointBalance;
    private Date occurredAt;

    public PointExhausted(Subscriber aggregate) {
        super(aggregate);
    }

    public PointExhausted() {
        super();
    }
}
//>>> DDD / Domain Event
