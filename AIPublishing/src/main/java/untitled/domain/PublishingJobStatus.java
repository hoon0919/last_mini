package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum PublishingJobStatus {
    REQUESTED,
    COVER_GENERATED,
    SUMMARY_GENERATED,
    COMPLETED,
    FAILED,
}
