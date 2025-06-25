package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum ManuscriptStatus {
    DRAFT,
    SAVED,
    PUBLISH_REQUESTED,
    PUBLISHED,
}
