package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AiCoverGenerated extends AbstractEvent {

    private String publishingJobId;
    private String coverImageUrl;
    private PublishingJobStatus status;

    public AiCoverGenerated(PublishingJob aggregate) {
        super(aggregate);
    }

    public AiCoverGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
