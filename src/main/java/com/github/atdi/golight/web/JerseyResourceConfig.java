package com.github.atdi.golight.web;

import com.github.atdi.golight.inject.GuiceInjectorCreator;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;

/**
 * Configure jersey.
 */
public class JerseyResourceConfig extends ResourceConfig {

    @Inject
    public JerseyResourceConfig(ServiceLocator serviceLocator) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(GuiceInjectorCreator.getInjector());
        packages("com.github.atdi.golight.resources");
    }
}
