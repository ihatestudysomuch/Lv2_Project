package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class NewsHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<News>> {

    @Override
    public EntityModel<News> process(EntityModel<News> model) {
        return model;
    }
}
