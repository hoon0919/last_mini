package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PublicationHistoryListQuery {

    private ManuscriptId manuscriptId;
    private PublicationResultStatus resultStatus;
    private Date requestedAtFrom;
    private Date requestedAtTo;
    private Integer page;
    private Integer size;
}
