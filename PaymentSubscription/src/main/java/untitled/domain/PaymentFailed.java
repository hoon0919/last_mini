package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentFailed extends AbstractEvent {

    private String paymentId;
    private SubscriberId subscriberId;
    private Integer amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;
    private String failReason;
    private Date timestamp;

    public PaymentFailed(Payment aggregate) {
        super(aggregate);
    }

    public PaymentFailed() {
        super();
    }
}
//>>> DDD / Domain Event
