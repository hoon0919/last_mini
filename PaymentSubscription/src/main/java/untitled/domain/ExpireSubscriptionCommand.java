package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ExpireSubscriptionCommand {

    private String subscriptionId;
    private Date expiredAt;
}
