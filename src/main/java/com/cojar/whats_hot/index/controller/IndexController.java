package com.cojar.whats_hot.index.controller;

import com.cojar.whats_hot.global.response.ResData;
import com.cojar.whats_hot.global.util.AppConfig;
import com.cojar.whats_hot.index.api_response.IndexApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Index", description = "API 인덱스")
@RequestMapping(produces = MediaTypes.HAL_JSON_VALUE)
@RestController
public class IndexController {

    @IndexApiResponse.Index
    @GetMapping("/api/index")
    public ResponseEntity index() {

        ResData resData = ResData.of(
                HttpStatus.OK,
                "S-00-00",
                "인덱스 링크 목록을 반환합니다",
                methodOn(IndexController.class).index()
        );
        resData.add(Link.of(AppConfig.getBaseURL() + "/swagger-ui/index.html#/Index/index").withRel("profile"));
        return ResponseEntity.ok()
                .body(resData);
    }
}
