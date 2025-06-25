package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AuthorApprovalListQuery {

    private ApprovalDecision decision;
    private Date decidedAtFrom;
    private Date decidedAtTo;
    private Integer page;
    private Integer size;
}
