package com.cojar.whats_hot.global.util;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @Autowired
    @Lazy
    private AppConfig self;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
          self.dataInitialize();
        };
    }

    @Transactional
    private void dataInitialize() {
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);

        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static String getBaseURL() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
    }
}
