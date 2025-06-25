package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MonthlyPlanSubscribed extends AbstractEvent {

    private String subscriptionId;
    private SubscriberId subscriberId;
    private PlanType planType;
    private SubscriptionStatus status;
    private Date startDate;
    private Date endDate;
    private PaymentId paymentId;

    public MonthlyPlanSubscribed(Subscription aggregate) {
        super(aggregate);
    }

    public MonthlyPlanSubscribed() {
        super();
    }
}
//>>> DDD / Domain Event
