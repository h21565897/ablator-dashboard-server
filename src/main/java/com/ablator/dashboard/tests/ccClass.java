package com.ablator.dashboard.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ccClass {
    @Autowired
    CC cc1;
    @Autowired
    CC cc2;

    public void print(){
        System.out.println(cc1.getIdn());
        System.out.println(cc2.getIdn());
    }
}
