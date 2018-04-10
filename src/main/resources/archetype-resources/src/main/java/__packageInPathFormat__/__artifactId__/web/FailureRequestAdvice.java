package ${package}.${artifactId}.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import ${package}.${artifactId}.framework.entry.rest.RestDataResponse;
import ${package}.${artifactId}.framework.entry.rest.RestMetaResponse;
import ${package}.${artifactId}.framework.error.CheckedException;

@ControllerAdvice
public class FailureRequestAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(FailureRequestAdvice.class);

    @ExceptionHandler(value = CheckedException.class)
    @ResponseBody
    public RestDataResponse checkedExceptionHandle(CheckedException exception) {
        String text = exception.getExceptionMessage().template;
        int code = exception.getExceptionMessage().code;
        if (exception.getParameter() != null && exception.getParameter().length > 0) {
            text = MessageFormatter.arrayFormat(exception.getExceptionMessage().template,
                    exception.getParameter()).getMessage();
        }
        return new RestDataResponse(new RestMetaResponse(null, code, text), null);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestDataResponse exceptionHandle(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);
        if (exception instanceof IllegalArgumentException) {
            return new RestDataResponse(new RestMetaResponse(null, 400, exception.getMessage()), null);
        } else {
            return new RestDataResponse(new RestMetaResponse(null, 500, "Internal error"), null);
        }
    }
}
