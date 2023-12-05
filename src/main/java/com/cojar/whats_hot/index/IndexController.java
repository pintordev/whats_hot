package com.cojar.whats_hot.index;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(produces = MediaTypes.HAL_JSON_VALUE)
@RestController
public class IndexController {

    @GetMapping("/api")
    public RepresentationModel index() {

        RepresentationModel index = new RepresentationModel();
        return index;
    }
}
