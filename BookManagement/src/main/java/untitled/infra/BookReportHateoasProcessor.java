package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class BookReportHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<BookReport>> {

    @Override
    public EntityModel<BookReport> process(EntityModel<BookReport> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "createbookreport"
                )
                .withRel("reatebookreport")
        );

        return model;
    }
}
