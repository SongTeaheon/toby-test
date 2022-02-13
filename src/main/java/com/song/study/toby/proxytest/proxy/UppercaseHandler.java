package com.song.study.toby.proxytest.proxy;

import com.song.study.toby.proxytest.target.TargetService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {

    private final TargetService targetService;

    public UppercaseHandler(TargetService targetService) {
        this.targetService = targetService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(targetService, args);
        if (ret instanceof String) {
            return ((String) ret).toUpperCase();
        }
        return ret;
    }
}
