package com.songjing.sbsd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * 假设这是一个带某个功能的服务bean
 */
@Component
public class DemoBeanService {

    @Autowired
    private ProperTies properTies;

    public void doSomething() {
        String name = properTies.getName();
        System.out.println(name);
    }
}
