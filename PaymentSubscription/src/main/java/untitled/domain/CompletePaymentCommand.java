package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CompletePaymentCommand {

    private String paymentId;
    private PaymentStatus status;
    private Date timestamp;
}
