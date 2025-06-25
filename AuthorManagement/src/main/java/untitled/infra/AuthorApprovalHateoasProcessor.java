package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class AuthorApprovalHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AuthorApproval>> {

    @Override
    public EntityModel<AuthorApproval> process(
        EntityModel<AuthorApproval> model
    ) {
        return model;
    }
}
