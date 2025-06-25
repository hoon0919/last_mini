package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.ContentManagementApplication;

@Entity
@Table(name = "PublicationHistory_table")
@Data
//<<< DDD / Aggregate Root
public class PublicationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publicationHistoryId;

    private Date requestedAt;

    private PublicationResultStatus resultStatus;

    private String resultMessage;

    private Date publishedAt;

    @Embedded
    private ManuscriptId manuscriptId;

    public static PublicationHistoryRepository repository() {
        PublicationHistoryRepository publicationHistoryRepository = ContentManagementApplication.applicationContext.getBean(
            PublicationHistoryRepository.class
        );
        return publicationHistoryRepository;
    }

    //<<< Clean Arch / Port Method
    public void createPublicationHistory(
        CreatePublicationHistoryCommand createPublicationHistoryCommand
    ) {
        //implement business logic here:

        PublicationHistoryCreated publicationHistoryCreated = new PublicationHistoryCreated(
            this
        );
        publicationHistoryCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updatePublicationStatus(
        UpdatePublicationStatusCommand updatePublicationStatusCommand
    ) {
        //implement business logic here:

        PublicationStatusUpdated publicationStatusUpdated = new PublicationStatusUpdated(
            this
        );
        publicationStatusUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
