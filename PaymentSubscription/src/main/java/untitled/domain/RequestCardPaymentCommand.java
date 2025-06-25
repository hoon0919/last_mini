package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestCardPaymentCommand {

    private SubscriberId subscriberId;
    private Integer amount;
    private PaymentMethod paymentMethod;
}
