package com.github.atdi.golight.modules;

import com.github.atdi.golight.services.Hello;
import com.github.atdi.golight.services.HelloService;
import com.google.inject.AbstractModule;

/**
 * Dummy guice module.
 */
public class DummyModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Hello.class).to(HelloService.class);
    }
}
