package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FailPublishingCommand {

    private String publishingJobId;
    private String failReason;
}
