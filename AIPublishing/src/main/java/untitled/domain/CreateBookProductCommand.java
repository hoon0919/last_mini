package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateBookProductCommand {

    private PublishingJobId publishingJobId;
    private Date registrationDate;
}
