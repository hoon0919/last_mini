package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PublicationHistoryCreated extends AbstractEvent {

    private Long publicationHistoryId;
    private ManuscriptId manuscriptId;
    private Date requestedAt;
    private PublicationResultStatus resultStatus;

    public PublicationHistoryCreated(PublicationHistory aggregate) {
        super(aggregate);
    }

    public PublicationHistoryCreated() {
        super();
    }
}
//>>> DDD / Domain Event
