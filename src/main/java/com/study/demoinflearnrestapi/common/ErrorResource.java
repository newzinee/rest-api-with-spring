package com.study.demoinflearnrestapi.common;

import com.study.demoinflearnrestapi.index.IndexController;
import org.springframework.hateoas.EntityModel;
import org.springframework.validation.Errors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author yj
 * @version 0.1.0
 * @since 2021/01/04
 */
public class ErrorResource extends EntityModel<Errors> {

    private Errors errors;

    public ErrorResource(Errors errors) {
        this.errors = EntityModel.of(errors).getContent();
        add(linkTo(methodOn(IndexController.class).index()).withRel("index"));
    }

    public Errors getErrors() {
        return errors;
    }

}
