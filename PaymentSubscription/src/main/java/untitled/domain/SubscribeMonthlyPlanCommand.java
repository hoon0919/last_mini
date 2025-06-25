package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubscribeMonthlyPlanCommand {

    private SubscriberId subscriberId;
    private PlanType planType;
    private PaymentMethod paymentMethod;
}
