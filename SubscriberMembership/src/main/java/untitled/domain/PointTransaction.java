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
@Table(name = "PointTransaction_table")
@Data
//<<< DDD / Aggregate Root
public class PointTransaction {

    @Id
    private String transactionId;

    private String subscriberId;

    private PointTransactionType type;

    private Integer amount;

    private Date createdAt;

    public static PointTransactionRepository repository() {
        PointTransactionRepository pointTransactionRepository = SubscriberMembershipApplication.applicationContext.getBean(
            PointTransactionRepository.class
        );
        return pointTransactionRepository;
    }

    //<<< Clean Arch / Port Method
    public void grantDefaultPoint(
        GrantDefaultPointCommand grantDefaultPointCommand
    ) {
        //implement business logic here:

        Event_173a event_173a = new Event_173a(this);
        event_173a.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void grantKtExtraPoint(
        GrantKtExtraPointCommand grantKtExtraPointCommand
    ) {
        //implement business logic here:

        Event_890a event_890a = new Event_890a(this);
        event_890a.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
