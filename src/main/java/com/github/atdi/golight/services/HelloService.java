package com.github.atdi.golight.services;

/**
 * Simple service.
 */
public class HelloService implements Hello {

    final String hello;

    public HelloService() {
        hello = "Hello %s";
    }

    @Override
    public String sayHelloTo(String name) {
        return String.format(hello, name);
    }
}
