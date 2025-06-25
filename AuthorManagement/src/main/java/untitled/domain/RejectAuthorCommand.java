package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RejectAuthorCommand {

    private Long authorId;
    private String rejectReason;
}
