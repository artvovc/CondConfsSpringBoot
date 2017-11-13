package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
@Conditional(MyCond.class)
public class Config1 {

    @Value("${value.prop}")
    private String str;

    @Bean
    public int say(){
        System.out.println("say " + str);
        return 0;
    }
}

class MyCond implements Condition {


    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        return conditionContext.getEnvironment().getProperty("value.prop", Boolean.class);
    }
}
