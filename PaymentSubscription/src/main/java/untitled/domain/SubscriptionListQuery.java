package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class SubscriptionListQuery {

    private SubscriberId subscriberId;
    private SubscriptionStatus status;
    private PlanType planType;
    private Date startDateFrom;
    private Date startDateTo;
    private Integer page;
    private Integer size;
}
