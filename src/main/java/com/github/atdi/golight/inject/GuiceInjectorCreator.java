package com.github.atdi.golight.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Singleton for creating the guice injector
 * before server startup.
 */
public class GuiceInjectorCreator {

    private static Injector injector;

    private GuiceInjectorCreator() {}

    /**
     * Static method for getting the injector
     * in the resource config class.
     * @return parent injector
     */
    public static Injector getInjector() {

        if(injector == null) {
            throw new RuntimeException("Guice injector is null");
        }

        return injector;
    }

    /**
     * Create the DI injector.
     * @param modules guice modules
     */
    public static void createInjector(Module... modules) {
        injector = Guice.createInjector(modules);
    }
}
