package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class PaymentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Payment>> {

    @Override
    public EntityModel<Payment> process(EntityModel<Payment> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "requestpointpayment"
                )
                .withRel("equestpointpayment")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/completepayment"
                )
                .withRel("completepayment")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "requestcardpayment"
                )
                .withRel("equestcardpayment")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/failpayment")
                .withRel("failpayment")
        );

        return model;
    }
}
