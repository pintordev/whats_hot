package com.cojar.whats_hot.global.util;

import com.cojar.whats_hot.domain.member.entity.Member;
import com.cojar.whats_hot.domain.member.entity.MemberRole;
import com.cojar.whats_hot.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InitConfig {

    private final MemberService memberService;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            if (this.memberService.hasNoMember()) {
                Member admin = this.memberService.signup("admin", "1234", "admin@test.com", List.of(MemberRole.ADMIN, MemberRole.USER));
                Member user1 = this.memberService.signup("user1", "1234", "user1@test.com", List.of(MemberRole.USER));
            }
        };
    }
}
