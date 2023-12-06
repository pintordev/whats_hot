package com.cojar.whats_hot.domain.member.controller;

import com.cojar.whats_hot.domain.member.api_response.MemberApiResponse;
import com.cojar.whats_hot.domain.member.request.MemberRequest;
import com.cojar.whats_hot.domain.member.response.MemberResponse;
import com.cojar.whats_hot.domain.member.service.MemberService;
import com.cojar.whats_hot.global.response.ResData;
import com.cojar.whats_hot.global.util.AppConfig;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Member", description = "API 인덱스")
@RequestMapping(value = "/api/members", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @MemberApiResponse.Login
    @PostMapping(value = "/login")
    public ResponseEntity login(@Valid @RequestBody MemberRequest.Login loginReq, Errors errors) {

        ResData resData = this.memberService.loginValidate(loginReq, errors);
        if (resData != null) return ResponseEntity.badRequest().body(resData);

        String accessToken = this.memberService.getAccessToken(loginReq);

        resData = ResData.of(
                HttpStatus.OK,
                "S-01-01",
                "액세스 토큰이 생성되었습니다",
                new MemberResponse.Login(accessToken),
                methodOn(this.getClass()).login(loginReq, errors)
        );
        resData.add(Link.of(AppConfig.getBaseURL() + "/swagger-ui/index.html#/Member/login").withRel("profile"));
        return ResponseEntity.ok()
                .body(resData);
    }
}
