package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Conditional(value = {ProfilesConditionCheck.class})
public class ProfileManager {
    @Autowired
    private Environment environment;

//    @Value("${testvalue}")
//    private String testValue;

    @GetMapping("/profiles")
    public String getActiveProfiles() {
//        System.out.println(testValue);
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
        return "Ok";
    }
}