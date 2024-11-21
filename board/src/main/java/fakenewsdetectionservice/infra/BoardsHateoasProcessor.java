package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BoardsHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Boards>> {

    @Override
    public EntityModel<Boards> process(EntityModel<Boards> model) {
        return model;
    }
}
