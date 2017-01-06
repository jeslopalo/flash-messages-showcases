package es.sandbox.ui.messages.spring.site;

import es.sandbox.ui.messages.Flash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);


    public GlobalControllerExceptionHandler() {
        LOGGER.info("Loading GlobalControllerExceptionHandler");
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String runtimeException(Flash flash, RuntimeException exception) {
        flash.error("There was an exception " + exception.getLocalizedMessage());
        LOGGER.error("Runtime", exception);
        return "home";
    }

    @ExceptionHandler(value = Exception.class)
    public String exception(Flash flash, Exception exception) {
        flash.error("There was an exception " + exception.getLocalizedMessage());
        LOGGER.error("Excepcion", exception);
        return "home";
    }
}
