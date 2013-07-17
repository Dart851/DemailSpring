package ru.t_systems.demail.controllers.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import ru.t_systems.demail.controllers.models.RegistrationForm;
import ru.t_systems.demail.service.UserService;


@Component("registrationValidator")
public class RegistrationFormValidation {

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> klass) {
        return RegistrationForm.class.isAssignableFrom(klass);
    }

    public void validate(Object target, Errors errors) {
        RegistrationForm registration = (RegistrationForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
                "NotEmpty.registration.userName",
                "User Name must not be Empty.");
        String userName = registration.getLogin();
        if ((userName.length()) > 50) {
            errors.rejectValue("login",
                    "lengthOfUser.registration.login",
                    "User Name must not more than 50 characters.");
        }
        if (userService.isRegistred(userName)) {
            errors.rejectValue("login",
                    "login.already.registered",
                    "User Name \"" + userName + "\" is already registred. Please change you login.");
        }

        if (!(registration.getPassword()).equals(registration
                .getConfirmPassword())) {
            errors.rejectValue("password",
                    "matchingPassword.registration.password",
                    "Password and Confirm Password Not match.");
        }
        /*if (!registration.getCountry().matches("-?\\d+(\\.\\d+)?") && !registration.getCountry().equals("NONE")) {
			errors.rejectValue("country",
					"country.registration.country",
					"Error with selected country");
		}*/

    }
}
