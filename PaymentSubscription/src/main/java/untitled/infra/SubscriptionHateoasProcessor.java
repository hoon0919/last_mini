package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class SubscriptionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Subscription>> {

    @Override
    public EntityModel<Subscription> process(EntityModel<Subscription> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "subscribemonthlyplan"
                )
                .withRel("ubscribemonthlyplan")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/expiresubscription"
                )
                .withRel("expiresubscription")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/cancelsubscription"
                )
                .withRel("cancelsubscription")
        );

        return model;
    }
}
