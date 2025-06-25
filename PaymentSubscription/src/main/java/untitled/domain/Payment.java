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

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    private String paymentId;

    private String subscriberId;

    private Integer amount;

    private PaymentMethod method;

    private PaymentStatus status;

    private Date timestamp;

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentSubscriptionApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public void requestPointPayment(
        RequestPointPaymentCommand requestPointPaymentCommand
    ) {
        //implement business logic here:

        PointPaymentRequested pointPaymentRequested = new PointPaymentRequested(
            this
        );
        pointPaymentRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completePayment(CompletePaymentCommand completePaymentCommand) {
        //implement business logic here:

        PaymentCompleted paymentCompleted = new PaymentCompleted(this);
        paymentCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void requestCardPayment(
        RequestCardPaymentCommand requestCardPaymentCommand
    ) {
        //implement business logic here:

        CardPaymentRequested cardPaymentRequested = new CardPaymentRequested(
            this
        );
        cardPaymentRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void failPayment(FailPaymentCommand failPaymentCommand) {
        //implement business logic here:

        PaymentFailed paymentFailed = new PaymentFailed(this);
        paymentFailed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
