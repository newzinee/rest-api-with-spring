package com.study.demoinflearnrestapi.events;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author yj
 * @version 0.1.0
 * @since 2021/01/02
 */
public class EventResource extends RepresentationModel {

    @JsonUnwrapped
    private Event event;

    public EventResource(Event event) {
        this.event = event;
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }

    public Event getEvent() {
        return this.event;
    }
}
