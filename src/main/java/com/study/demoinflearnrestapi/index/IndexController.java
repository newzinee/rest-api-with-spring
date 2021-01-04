package com.study.demoinflearnrestapi.index;

import com.study.demoinflearnrestapi.events.EventController;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author yj
 * @version 0.1.0
 * @since 2021/01/04
 */
@RestController
public class IndexController {

    @GetMapping("/api")
    public RepresentationModel index() {
        var index = new RepresentationModel();
        index.add(linkTo(EventController.class).withRel("events"));
        return index;
    }
}
