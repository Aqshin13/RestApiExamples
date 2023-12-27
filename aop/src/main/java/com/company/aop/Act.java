package com.company.aop;

import org.springframework.stereotype.Component;


@Component
public class Act {
    
    public String foo(String name){
        System.out.println(name+" This is foo in Act class");
        return name;
    }
    
}
