package ${package}.${artifactId}.framework.error;

public final class DefaultExceptionMessage {

    private DefaultExceptionMessage() {}

    public static final ExceptionMessage ILLEGAL_PARAMETER = ExceptionMessage.newInstance(100001, "Illegal param, {}: {}");
}
