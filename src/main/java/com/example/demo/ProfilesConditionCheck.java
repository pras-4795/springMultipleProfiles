package com.example.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProfilesConditionCheck implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(context.getEnvironment().getActiveProfiles());
        return context.getEnvironment().acceptsProfiles(Profiles.of("dev"))
                && context.getEnvironment().acceptsProfiles(Profiles.of("local"));
    }
}
