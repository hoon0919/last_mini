package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class PublishingJobHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PublishingJob>> {

    @Override
    public EntityModel<PublishingJob> process(
        EntityModel<PublishingJob> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "failpublishing")
                .withRel("ailpublishing")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "requestpublishing"
                )
                .withRel("equestpublishing")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "completepublishing"
                )
                .withRel("ompletepublishing")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "generateaisummary"
                )
                .withRel("enerateaisummary")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "generateaicover")
                .withRel("enerateaicover")
        );

        return model;
    }
}
