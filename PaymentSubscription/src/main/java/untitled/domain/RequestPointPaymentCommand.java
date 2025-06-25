package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestPointPaymentCommand {

    private SubscriberId subscriberId;
    private BookId bookId;
    private Integer amount;
}
