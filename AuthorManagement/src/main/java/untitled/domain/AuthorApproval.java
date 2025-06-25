package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AuthorManagementApplication;

@Entity
@Table(name = "AuthorApproval_table")
@Data
//<<< DDD / Aggregate Root
public class AuthorApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long approvalId;

    private ApprovalDecision decision;

    private Date decidedAt;

    private Long decidedBy;

    private String reason;

    @Embedded
    private AuthorId authorId;

    public static AuthorApprovalRepository repository() {
        AuthorApprovalRepository authorApprovalRepository = AuthorManagementApplication.applicationContext.getBean(
            AuthorApprovalRepository.class
        );
        return authorApprovalRepository;
    }
}
//>>> DDD / Aggregate Root
