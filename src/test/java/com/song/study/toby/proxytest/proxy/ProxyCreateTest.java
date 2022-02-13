package com.song.study.toby.proxytest.proxy;

import com.song.study.toby.proxytest.target.TargetService;
import com.song.study.toby.proxytest.target.TargetServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;

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

    @Test
    void proxyFactoryBean() {
        // 타깃 인터페이스가 필요없다?!
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new TargetServiceImpl()); // 타깃 설정 -> 타깃 객체가 인터페이스를 검출해서 자동으로 구현해야하는 메서드를 만들어낸다.
        pfBean.addAdvice(new UppercaseAdvice()); // 부가기능을 담은 어드바이스를 추가한다.

        TargetService targetService = (TargetService) pfBean.getObject(); // 생성된 프록시를 가져온다.

        assert targetService != null;
        System.out.println(targetService.test());
    }
}
