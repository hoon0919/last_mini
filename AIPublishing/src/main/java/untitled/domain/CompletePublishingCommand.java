package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CompletePublishingCommand {

    private String publishingJobId;
    private String coverImageUrl;
    private String summaryText;
    private String productId;
}
