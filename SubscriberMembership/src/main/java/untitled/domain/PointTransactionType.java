package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum PointTransactionType {
    DEFAULT_GRANT,
    KT_EXTRA_GRANT,
    BOOK_USE,
    SUBSCRIPTION_USE,
}
