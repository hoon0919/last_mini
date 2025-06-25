package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.SubscriberMembershipApplication;

@Entity
@Table(name = "Subscriber_table")
@Data
//<<< DDD / Aggregate Root
public class Subscriber {

    @Id
    private String subscriberId;

    private String name;

    private String phoneNumber;

    private Boolean ktVerified;

    private Integer pointBalance;

    public static SubscriberRepository repository() {
        SubscriberRepository subscriberRepository = SubscriberMembershipApplication.applicationContext.getBean(
            SubscriberRepository.class
        );
        return subscriberRepository;
    }

    //<<< Clean Arch / Port Method
    public void registerSubscriber(
        RegisterSubscriberCommand registerSubscriberCommand
    ) {
        //implement business logic here:

        PointGranted pointGranted = new PointGranted(this);
        pointGranted.publishAfterCommit();
        SubscriberRegistered subscriberRegistered = new SubscriberRegistered(
            this
        );
        subscriberRegistered.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void usePointForBook(UsePointForBookCommand usePointForBookCommand) {
        //implement business logic here:

        PointUsedForBook pointUsedForBook = new PointUsedForBook(this);
        pointUsedForBook.publishAfterCommit();
        PointExhausted pointExhausted = new PointExhausted(this);
        pointExhausted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void verifyKtMember(VerifyKtMemberCommand verifyKtMemberCommand) {
        //implement business logic here:

        KtMemberVerified ktMemberVerified = new KtMemberVerified(this);
        ktMemberVerified.publishAfterCommit();
        PointGranted pointGranted = new PointGranted(this);
        pointGranted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
