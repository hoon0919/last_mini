package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PaymentHistoryQuery {

    private SubscriberId subscriberId;
    private PaymentStatus status;
    private PaymentMethod paymentMethod;
    private Date timestampFrom;
    private Date timestampTo;
    private Integer page;
    private Integer size;
}
