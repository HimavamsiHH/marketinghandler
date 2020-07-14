package com.marketing.engine.Security;



import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionTrackingMode;
import java.util.EnumSet;

import com.marketing.engine.Spring.MvcConfig;
import com.marketing.engine.Web.monitoring.SessionListenerWithMetrics;


public class SecurityWebApplicationInitializer implements ServletContextInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(MvcConfig.class);
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
        servletContext.addListener(SessionListenerWithMetrics.class);
        servletContext.addListener(new RequestContextListener());
        rootContext.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
