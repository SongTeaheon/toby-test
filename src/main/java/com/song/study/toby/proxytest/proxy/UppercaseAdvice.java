package com.song.study.toby.proxytest.proxy;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class UppercaseAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // MethodInvocation이 메서드 정보와 함께 타깃 오브젝트 정보를 알고 있음.
        // 이 때문에 UppercaseAdvice는 target 클래스 정보를 갖고 있지 않아도 된다. -> 여러 클래스에 하나의 Advice 객체를 사용할 수 있다.
        String ret = (String) invocation.proceed();
        assert ret != null;
        return ret.toUpperCase();
    }
}
