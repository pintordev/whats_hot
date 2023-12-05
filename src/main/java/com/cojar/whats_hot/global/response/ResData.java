package com.cojar.whats_hot.global.response;

import com.cojar.whats_hot.index.IndexController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ResData<T> extends RepresentationModel {

    private final HttpStatus status;
    private final String code;
    private final String message;
    private final T data;

    public static <T> ResData<T> of(HttpStatus status,
                                    String code,
                                    String message,
                                    T data,
                                    Class<?> controller,
                                    Object pathVariable) {

        ResData resData = new ResData<>(status, code, message, data);

        if (data instanceof Errors) {
            resData.add(linkTo(methodOn(IndexController.class).index()).withRel("index"));
            return resData;
        }

        // self 링크 추가
        if (pathVariable != null) {
            resData.add(linkTo(controller).slash(pathVariable.toString()).withSelfRel());
        } else {
            resData.add(linkTo(controller).withSelfRel());
        }

        return resData;
    }

    public static <T> ResData<T> of(HttpStatus status,
                                    String code,
                                    String message,
                                    T data,
                                    Class<?> controller) {
        return ResData.of(status, code, message, data, controller, null);
    }

    public static <T> ResData<T> of(HttpStatus status,
                                    String code,
                                    String message,
                                    T data) {
        return ResData.of(status, code, message, data, null, null);
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
