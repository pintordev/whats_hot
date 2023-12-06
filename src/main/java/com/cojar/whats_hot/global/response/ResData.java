package com.cojar.whats_hot.global.response;

import com.cojar.whats_hot.index.controller.IndexController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ResData<T> extends RepresentationModel {

    private final HttpStatus status;
    private final boolean success;
    private final String code;
    private final String message;
    private final T data;

    public ResData(HttpStatus status,
                   String code,
                   String message,
                   T data) {
        this.status = status;
        this.success = status.is2xxSuccessful();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResData<T> of(HttpStatus status,
                                    String code,
                                    String message,
                                    T data,
                                    ResponseEntity method) {

        ResData resData = new ResData<>(status, code, message, data);

        if (data instanceof Errors) {
            resData.add(linkTo(methodOn(IndexController.class).index()).withRel("index"));
        }

        if (method == null) return resData;

        resData.add(linkTo(method).withSelfRel());

        return resData;
    }

    public static <T> ResData<T> of(HttpStatus status,
                                    String code,
                                    String message) {

        return ResData.of(status, code, message, null, null);
    }

    public static <T> ResData<T> of(HttpStatus status,
                                    String code,
                                    String message,
                                    T data) {

        return ResData.of(status, code, message, data, null);
    }

    public static <T> ResData<T> of(HttpStatus status,
                                    String code,
                                    String message,
                                    ResponseEntity method) {

        return ResData.of(status, code, message, null, method);
    }

    @JsonIgnore
    public Link getSelf() {
        return this.getRequiredLink("self");
    }

    @JsonIgnore
    public URI getSelfUri() {
        return this.getSelf().toUri();
    }
}
