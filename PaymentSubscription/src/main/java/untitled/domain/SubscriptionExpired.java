package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionExpired extends AbstractEvent {

    private String subscriptionId;
    private SubscriberId subscriberId;
    private PlanType planType;
    private SubscriptionStatus status;
    private Date endDate;
    private Date expiredAt;

    public SubscriptionExpired(Subscription aggregate) {
        super(aggregate);
    }

    public SubscriptionExpired() {
        super();
    }
}
//>>> DDD / Domain Event
