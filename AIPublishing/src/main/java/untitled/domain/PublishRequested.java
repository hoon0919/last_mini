package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PublishRequested extends AbstractEvent {

    private String publishingJobId;
    private AuthorId authorId;
    private String contentId;
    private PublishingJobStatus status;
    private Date requestedAt;

    public PublishRequested(PublishingJob aggregate) {
        super(aggregate);
    }

    public PublishRequested() {
        super();
    }
}
//>>> DDD / Domain Event
