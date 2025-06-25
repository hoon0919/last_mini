package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorRegistrationRequested extends AbstractEvent {

    private Long authorId;
    private String name;
    private String email;
    private AuthorBio bio;
    private PortfolioUrl portfolioUrl;
    private AuthorRegistrationStatus registrationStatus;
    private Date registeredAt;

    public AuthorRegistrationRequested(Author aggregate) {
        super(aggregate);
    }

    public AuthorRegistrationRequested() {
        super();
    }
}
//>>> DDD / Domain Event
