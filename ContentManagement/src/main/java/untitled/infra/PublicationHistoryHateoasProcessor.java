package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class PublicationHistoryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PublicationHistory>> {

    @Override
    public EntityModel<PublicationHistory> process(
        EntityModel<PublicationHistory> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "createpublicationhistory"
                )
                .withRel("reatepublicationhistory")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatepublicationstatus"
                )
                .withRel("updatepublicationstatus")
        );

        return model;
    }
}
