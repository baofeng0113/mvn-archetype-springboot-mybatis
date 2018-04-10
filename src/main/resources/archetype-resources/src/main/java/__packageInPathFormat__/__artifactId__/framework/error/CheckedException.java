package ${package}.${artifactId}.framework.error;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class CheckedException extends RuntimeException implements Serializable {

    @Getter @Setter private ExceptionMessage exceptionMessage;

    @Getter @Setter private Object[] parameter;

    public CheckedException(ExceptionMessage exceptionMessage, Object... parameter) {
        this.parameter = parameter;
        this.exceptionMessage = exceptionMessage;
    }

    public CheckedException(ExceptionMessage exceptionMessage, Throwable throwable) {
        super(throwable);
        this.exceptionMessage = exceptionMessage;
    }
}
