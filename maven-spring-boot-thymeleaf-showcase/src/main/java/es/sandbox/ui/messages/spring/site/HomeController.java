package es.sandbox.ui.messages.spring.site;

import es.sandbox.ui.messages.Flash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static es.sandbox.ui.messages.argument.Arguments.link;
import static es.sandbox.ui.messages.argument.Arguments.text;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/")
    public String home(Flash flash) {
        flash.info("Welcome to flash messages showcase!");

        LOGGER.debug("{} -> F({}): {}", "/", "hone", flash);
        return "home";
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String a(Flash flash, Model model, HttpServletRequest request) {

        flash.success("sm.controller.method.A");

        LOGGER.debug("{} -> R({}): {}", "A", "B", flash);
        return "redirect:/b";
    }

    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public String b(Flash flash) {
        flash.success("sm.controller.method.B");

        LOGGER.debug("{} -> R({}): {}", "B", "D", flash);
        return "redirect:/d";
    }

    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public String c() {

        LOGGER.debug("{} -> R({}): {}", "C", "D", "unknown");
        return "redirect:/d";
    }

    @RequestMapping(value = "/d", method = RequestMethod.GET)
    public String d(Flash flash, HttpServletRequest request) {
        flash.warning("sm.controller.method.D");
        flash.warning("sm.controller.method.D.withArgs",
            link("/e").title("sm.controller.method.D.linktitle", 32).cssClass("alert-link"),
            text("sm.controller.method.A.texto", new Integer(4)));

        LOGGER.debug("{} -> F({}): {}", "D", "home", flash);

        return "home";
    }

    @RequestMapping(value = "/e", method = RequestMethod.GET)
    public String e(Flash flash) {

        flash.success("<b>Hey!</b> I'm passing through <b>E</b> controller! (without i18n)");
        flash.success("<b>Hey!</b> I'm passing through <b>E</b> controller! (without i18n)");
        flash.success("<b>Hey!</b> I'm passing through <b>E</b> controller! (without i18n)");
        flash.success("<b>Hey!</b> I'm passing through <b>E</b> controller! (without i18n)");

        LOGGER.debug("{} -> R({}): {}", "E", "D", flash);
        return "redirect:/d";
    }

    @RequestMapping(value = "/f", method = RequestMethod.GET)
    public String f(Flash flash, HttpServletRequest request) {
        flash.success("<b>Hey!</b> I'm passing through <b>F</b> controller! (without i18n)");

        LOGGER.debug("{} -> R({}): {}", "F", "C", flash);

        return "redirect:/c";
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception(Flash flash, HttpServletRequest request) {
        flash.warning("<b>Hey!</b> I'm passing through <b>exception</b> controller! (without i18n)");

        LOGGER.debug("{} -> F({}): {}", "exception", "home", flash);

        throw new IllegalArgumentException("Exception message!!!!");
    }

    @RequestMapping(value = "/global-exception", method = RequestMethod.GET)
    public String globalException(Flash flash, HttpServletRequest request) {
        flash.warning("<b>Hey!</b> I'm passing through <b>global-exception</b> controller! (without i18n)");

        LOGGER.debug("{} -> F({}): {}", "global-exception", "home", flash);

        throw new UnsupportedOperationException("Unsupported Operation Exception message!!!!");
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(IllegalArgumentException exception, Flash flash) {
        LOGGER.error("Error!", exception);
        flash.error("Warning: " + exception.getLocalizedMessage());
        return "home";
    }
}
