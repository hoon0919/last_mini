package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class SubscriberHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Subscriber>> {

    @Override
    public EntityModel<Subscriber> process(EntityModel<Subscriber> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "registersubscriber"
                )
                .withRel("egistersubscriber")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "usepointforbook")
                .withRel("sepointforbook")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "verifyktmember")
                .withRel("erifyktmember")
        );

        return model;
    }
}
