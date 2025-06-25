package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdatePublicationStatusCommand {

    private Long publicationHistoryId;
    private PublicationResultStatus resultStatus;
    private String resultMessage;
    private Date publishedAt;
}
