package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AnalysisHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Analysis>> {

    @Override
    public EntityModel<Analysis> process(EntityModel<Analysis> model) {
        return model;
    }
}
