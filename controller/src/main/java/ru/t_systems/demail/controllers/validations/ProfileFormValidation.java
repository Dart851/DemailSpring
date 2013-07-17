package ru.t_systems.demail.controllers.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import ru.t_systems.demail.controllers.models.ProfileForm;
import ru.t_systems.demail.service.UserService;

@Component("editProfileValidator")
public class ProfileFormValidation {

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> klass) {
        return ProfileForm.class.isAssignableFrom(klass);
    }

    public void validate(Object target, Errors errors) {
        ProfileForm editProfile = (ProfileForm) target;


        if (!(editProfile.getPassword()).equals(editProfile
                .getConfirmPassword())) {
            errors.rejectValue("password",
                    "matchingPassword.profile.password",
                    "Password and Confirm Password Not match.");
        }
        String a = editProfile.getOldPassword();

        String b = userService.getUser(
                SecurityContextHolder.getContext().getAuthentication()
                        .getName()).getPassword();

        if (a.isEmpty() && !(a).equals(b)) {
            errors.rejectValue("oldPassword",
                    "matchingPassword.profile.oldPassword",
                    "Password incorrect");

        }
    }
}
