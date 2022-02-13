package com.song.study.toby.proxytest.proxy;

public class TargetServiceImpl implements TargetService {
    @Override
    public String test() {
        return "test";
    }
}
