package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreatePublicationHistoryCommand {

    private ManuscriptId manuscriptId;
    private Date requestedAt;
}
