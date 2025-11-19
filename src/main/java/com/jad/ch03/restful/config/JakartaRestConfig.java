package com.jad.ch03.restful.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configuring the REST resource application Path by extending jakarta.ws.rs.core.Application
 */
@ApplicationPath("resources")
public class JakartaRestConfig extends Application {

}
