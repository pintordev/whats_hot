package com.cojar.whats_hot.domain.member.api_response;

import com.cojar.whats_hot.global.response.ResData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.hateoas.MediaTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface MemberApiResponse {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(
            summary = "회원 로그인",
            description = "성공 시 액세스 토큰을 발급한다",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "정상 응답",
                            content = @Content(mediaType = MediaTypes.HAL_JSON_VALUE,
                                    schema = @Schema(implementation = ResData.class),
                                    examples = @ExampleObject(value = """
                                            {
                                                "status": "OK",
                                                "success": true,
                                                "code": "S-01-01",
                                                "message": "액세스 토큰이 생성되었습니다",
                                                "data": {
                                                    "accessToken": "accessToken"
                                                },
                                                "_links": {
                                                    "self": {
                                                        "href": "http://localhost:8080/api/members/login"
                                                    },
                                                    "profile": {
                                                        "href": "http://localhost:8080/swagger-ui/index.html#/Member/login"
                                                    }
                                                }
                                            }
                                            """
                                    )
                            )
                    )
            }
    )
    public @interface Login {
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(
            summary = "회원 정보 조회",
            description = "현재 로그인된 회원 정보를 반환한다",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "정상 응답",
                            content = @Content(mediaType = MediaTypes.HAL_JSON_VALUE,
                                    schema = @Schema(implementation = ResData.class),
                                    examples = @ExampleObject(value = """
                                            {
                                                "status": "OK",
                                                "success": true,
                                                "code": "S-01-02",
                                                "message": "로그인된 회원 정보를 반환합니다",
                                                "data": {
                                                    "id": 2,
                                                    "createDate": "2023-12-06T16:30:32.952443",
                                                    "modifyDate": "2023-12-06T16:30:32.952443",
                                                    "username": "user",
                                                    "email": "user@test.com",
                                                    "authorities": [
                                                        "USER"
                                                    ]
                                                },
                                                "_links": {
                                                    "self": {
                                                        "href": "http://localhost:8080/api/members/me"
                                                    },
                                                    "profile": {
                                                        "href": "http://localhost:8080/swagger-ui/index.html#/Member/me"
                                                    }
                                                }
                                            }
                                            """
                                    )
                            )
                    )
            }
    )
    public @interface Me {
    }
}
