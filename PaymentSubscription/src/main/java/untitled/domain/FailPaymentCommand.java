package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FailPaymentCommand {

    private String paymentId;
    private String failReason;
    private Date timestamp;
}
