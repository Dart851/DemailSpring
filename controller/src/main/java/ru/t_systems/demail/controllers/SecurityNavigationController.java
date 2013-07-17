package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.t_systems.demail.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SecurityNavigationController {

    @Autowired
    private UserService userService;

    // old
    @RequestMapping(value = URL.LOGIN, method = RequestMethod.GET)
    public ModelAndView loginForm(HttpServletRequest request) {

        // if (!SecurityContextHolder.getContext()
        // .getAuthentication().isAuthenticated()){
        if (request.getUserPrincipal() != null) {

            return new ModelAndView(URL.REDIRECT + URL.MAILBOX);
        } else {
            return new ModelAndView(URL.LOGIN_JSP);
        }
        // } else {
        // return new ModelAndView("redirect:/mail/mail-box.html");
        // }

    }

    @RequestMapping(value = "/error-login", method = RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView(URL.LOGIN_JSP);
        modelAndView.addObject("error", true);
        return modelAndView;
    }

    @RequestMapping(value = "/success-login", method = RequestMethod.GET)
    public ModelAndView successLogin() {
        return new ModelAndView("success-login");
    }

}