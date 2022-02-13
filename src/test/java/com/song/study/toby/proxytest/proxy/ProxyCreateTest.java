package com.song.study.toby.proxytest.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ProxyCreateTest {

    @Test
    void createProxy() {
        TargetService instance = (TargetService)Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class[]{TargetService.class},
            new UppercaseHandler(new TargetServiceImpl())
        );

        System.out.println(instance.test());
    }
}
