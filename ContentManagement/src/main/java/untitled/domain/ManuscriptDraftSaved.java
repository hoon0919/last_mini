package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptDraftSaved extends AbstractEvent {

    private Long manuscriptId;
    private AuthorId authorId;
    private String title;
    private String content;
    private ManuscriptStatus status;
    private Date createdAt;
    private Date updatedAt;

    public ManuscriptDraftSaved(Manuscript aggregate) {
        super(aggregate);
    }

    public ManuscriptDraftSaved() {
        super();
    }
}
//>>> DDD / Domain Event
