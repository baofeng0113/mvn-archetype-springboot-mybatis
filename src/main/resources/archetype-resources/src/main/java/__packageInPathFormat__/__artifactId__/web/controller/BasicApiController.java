package ${package}.${artifactId}.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ${package}.${artifactId}.framework.entry.rest.RestDataResponse;
import ${package}.${artifactId}.framework.entry.rest.RestMetaResponse;

public abstract class BasicApiController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected RestDataResponse newRestDataResponse(Object result) {
        return new RestDataResponse(new RestMetaResponse(null, 200, ""), result);
    }
}
