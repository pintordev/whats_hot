package com.cojar.whats_hot.domain.member.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MemberRequest {

    @Getter
    public static class Login {

        @NotBlank
        private String username;

        @NotBlank
        private String password;
    }
}
