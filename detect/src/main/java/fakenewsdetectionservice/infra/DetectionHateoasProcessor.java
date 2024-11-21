package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DetectionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Detection>> {

    @Override
    public EntityModel<Detection> process(EntityModel<Detection> model) {
        return model;
    }
}
