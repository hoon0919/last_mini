package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class BookProductHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<BookProduct>> {

    @Override
    public EntityModel<BookProduct> process(EntityModel<BookProduct> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "createbookproduct"
                )
                .withRel("reatebookproduct")
        );

        return model;
    }
}
