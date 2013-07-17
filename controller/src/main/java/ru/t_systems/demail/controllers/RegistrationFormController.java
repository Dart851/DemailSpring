package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.t_systems.demail.controllers.models.RegistrationForm;
import ru.t_systems.demail.controllers.validations.RegistrationFormValidation;
import ru.t_systems.demail.model.user.Account;
import ru.t_systems.demail.model.user.User;
import ru.t_systems.demail.service.RoleService;
import ru.t_systems.demail.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = URL.REGISTRATION)
public class RegistrationFormController {
    /*
	 * @Autowired private CountryEditor countryEditor;
	 */

    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    protected AuthenticationManager authenticationManager;
    @Autowired
    private RegistrationFormValidation registrationValidation;
    @Autowired
    private UserService userService;

	/*
	 * @Autowired private CountryService countryService;
	 */
    @Autowired
    private RoleService roleService;

    public void setRegistrationValidation(
            RegistrationFormValidation registrationValidation) {
        this.registrationValidation = registrationValidation;
    }

    // Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistration(Map<String, RegistrationForm> model) {
        RegistrationForm registration = new RegistrationForm();
        model.put("registration", registration);
        return URL.REGISTRATION_JSP;
    }

    // Process the form.
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute("registration") RegistrationForm registration,
                                      BindingResult result, HttpServletRequest request) {
        // set custom Validation by user
        registrationValidation.validate(registration, result);

        if (result.hasErrors()) {
            System.out.println("-------------------------HAS ERROR");
            return URL.REGISTRATION_JSP;
            //return new ModelAndView(URL.REGISTRATION_JSP).addObject("registration", registration);
        } else {
            User user = new User();

            user.setLogin(registration.getLogin());
            user.setPassword(registration.getPassword());
            user.setRole(roleService.getRole(2));
            user.setEmail(registration.getEmail());
            user.setLastName(registration.getLastName());
            user.setFirstName(registration.getFistName());
            // user.setBirthDay(registration.get)
			/*
			 * if (registration.getCountry() != null &&
			 * !registration.getCountry().equals("NONE")) {
			 * user.setCountry((registration.getCountry())); }
			 */

            // user.setCountry(new Country());

            Account account = new Account();
            account.setAccountName(user.getLogin() + "@de-mail.de");
            user.setAccounts(new HashSet<Account>(Arrays.asList(account)));

            userService.update(user);

            // Auto login after registration
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    user.getLogin(), user.getPassword());
            request.getSession();
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authenticatedUser = authenticationManager
                    .authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(
                    authenticatedUser);

            //return new ModelAndView(URL.REDIRECT+URL.MAILBOX);
            return URL.MAILBOX_JSP;
        }

    }

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(Country.class, this.countryEditor); }
	 * 
	 * @ModelAttribute("countryList") public List<Country> populateCountryList()
	 * {
	 * 
	 * return countryService.getAllCountry(); }
	 */

    @ModelAttribute("gender")
    public List<String> genderList() {

        return Arrays.asList("Male", "Female");
    }
}
