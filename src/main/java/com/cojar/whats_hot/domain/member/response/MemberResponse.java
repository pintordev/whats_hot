package com.cojar.whats_hot.domain.member.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberResponse {

    @Getter
    @AllArgsConstructor
    public static class Login {

        private final String accessToken;
    }
}
