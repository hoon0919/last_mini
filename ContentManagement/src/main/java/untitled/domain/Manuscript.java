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
@Table(name = "Manuscript_table")
@Data
//<<< DDD / Aggregate Root
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manuscriptId;

    private String title;

    private String content;

    private ManuscriptStatus status;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private AuthorId authorId;

    public static ManuscriptRepository repository() {
        ManuscriptRepository manuscriptRepository = ContentManagementApplication.applicationContext.getBean(
            ManuscriptRepository.class
        );
        return manuscriptRepository;
    }

    //<<< Clean Arch / Port Method
    public void saveManuscriptDraft(
        SaveManuscriptDraftCommand saveManuscriptDraftCommand
    ) {
        //implement business logic here:

        ManuscriptDraftSaved manuscriptDraftSaved = new ManuscriptDraftSaved(
            this
        );
        manuscriptDraftSaved.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void saveManuscriptFinal(
        SaveManuscriptFinalCommand saveManuscriptFinalCommand
    ) {
        //implement business logic here:

        ManuscriptCreated manuscriptCreated = new ManuscriptCreated(this);
        manuscriptCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
