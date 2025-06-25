package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriberRegistered extends AbstractEvent {

    private String subscriberId;
    private String name;
    private String phoneNumber;
    private Boolean ktVerified;
    private Integer pointBalance;

    public SubscriberRegistered(Subscriber aggregate) {
        super(aggregate);
    }

    public SubscriberRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
