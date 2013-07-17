package ru.t_systems.demail.controllers.models;

//import org.hibernate.validator.constraints.NotEmpty;

import ru.t_systems.demail.model.user.Country;
import ru.t_systems.demail.model.user.User;

public class ProfileForm {

    //@NotEmpty
    private String oldPassword;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Country country;

    public ProfileForm(User user) {

        this.country = user.getCountry();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();

    }

    public ProfileForm() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public User updateUser(User user) {
        user.setCountry(this.getCountry());
        user.setEmail(this.getEmail());
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());

        if (!this.getPassword().isEmpty()
                && !user.getPassword().equals(this.getPassword())) {
            user.setPassword(this.getPassword());
        }

        return user;

    }

}