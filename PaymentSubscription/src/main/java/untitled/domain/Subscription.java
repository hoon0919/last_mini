package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.PaymentSubscriptionApplication;
import untitled.domain.MonthlyPlanSubscribed;
import untitled.domain.SubscriptionCancelled;
import untitled.domain.SubscriptionExpired;

@Entity
@Table(name = "Subscription_table")
@Data
//<<< DDD / Aggregate Root
public class Subscription {

    @Id
    private String subscriptionId;

    private PlanType planType;

    private SubscriptionStatus status;

    private Date startDate;

    private Date endDate;

    @Embedded
    private SubscriberId subscriberId;

    @Embedded
    private PaymentId paymentId;

    @PostPersist
    public void onPostPersist() {
        MonthlyPlanSubscribed monthlyPlanSubscribed = new MonthlyPlanSubscribed(
            this
        );
        monthlyPlanSubscribed.publishAfterCommit();

        SubscriptionCancelled subscriptionCancelled = new SubscriptionCancelled(
            this
        );
        subscriptionCancelled.publishAfterCommit();

        SubscriptionExpired subscriptionExpired = new SubscriptionExpired(this);
        subscriptionExpired.publishAfterCommit();
    }

    public static SubscriptionRepository repository() {
        SubscriptionRepository subscriptionRepository = PaymentSubscriptionApplication.applicationContext.getBean(
            SubscriptionRepository.class
        );
        return subscriptionRepository;
    }

    //<<< Clean Arch / Port Method
    public void subscribeMonthlyPlan(
        SubscribeMonthlyPlanCommand subscribeMonthlyPlanCommand
    ) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void expireSubscription(
        ExpireSubscriptionCommand expireSubscriptionCommand
    ) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void cancelSubscription(
        CancelSubscriptionCommand cancelSubscriptionCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
