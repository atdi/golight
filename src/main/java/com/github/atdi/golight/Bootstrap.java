package com.github.atdi.golight;

import com.github.atdi.golight.inject.GuiceInjectorCreator;
import com.github.atdi.golight.modules.DummyModule;
import com.github.atdi.golight.web.JerseyResourceConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

public class Bootstrap {

    public static void main(String[] args) throws Exception {
        GuiceInjectorCreator.createInjector(new DummyModule());
        Server server = new Server(8000);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/");
        servletContextHandler.addServlet(DefaultServlet.class, "/");
        ServletHolder jerseyServletHolder = new ServletHolder(new ServletContainer());
        jerseyServletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyResourceConfig.class.getCanonicalName());
        servletContextHandler.addServlet(jerseyServletHolder, "/api/*");
        server.start();
        server.join();
    }
}
