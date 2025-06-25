package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class PointTransactionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PointTransaction>> {

    @Override
    public EntityModel<PointTransaction> process(
        EntityModel<PointTransaction> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "grantdefaultpoint"
                )
                .withRel("rantdefaultpoint")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "grantktextrapoint"
                )
                .withRel("rantktextrapoint")
        );

        return model;
    }
}
