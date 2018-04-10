package ${package}.${artifactId}.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UserActionTrackUtil {

    private final Logger LOGGER = LoggerFactory.getLogger(UserActionTrackUtil.class);

    public static void newRestDataResponse(String username, String requestURI, String header, String params) {
        LOGGER.info("{} request {}, headers: {}, params: {}", username, requestURI, header, params);
    }
}
