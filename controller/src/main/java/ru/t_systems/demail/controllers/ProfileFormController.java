package ru.t_systems.demail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.t_systems.demail.controllers.editors.CountryEditor;
import ru.t_systems.demail.controllers.models.ProfileForm;
import ru.t_systems.demail.controllers.validations.ProfileFormValidation;
import ru.t_systems.demail.model.user.Country;
import ru.t_systems.demail.model.user.User;
import ru.t_systems.demail.service.CountryService;
import ru.t_systems.demail.service.RoleService;
import ru.t_systems.demail.service.UserService;
import ru.t_systems.demail.service.message.MessageService;
import ru.t_systems.demail.service.message.MessageStatusService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mail/profile.html")
public class ProfileFormController {
    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    protected AuthenticationManager authenticationManager;
    @Autowired
    private CountryEditor countryEditor;
    @Autowired
    private ProfileFormValidation editProfileValidation;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private MessageStatusService messageStatuss;
    @Autowired
    private MessageService messageService;

    // Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showEditProfile(Map<String, ProfileForm> model) {
        User user = userService.getUser(SecurityContextHolder.getContext()
                .getAuthentication().getName());
        ProfileForm editProfile = new ProfileForm(user);
        model.put("profile", editProfile);
//		Set<Account> st = user.getAccounts();
//		System.out.println("Account n = "+st.size());
//		List<MessageStatuss> mst = new ArrayList<MessageStatuss>();
//		for(Account ac :st){
//		mst.addAll(ac.getStatus());
//		}
//		System.out.println("Status n = "+mst.size());
//		List<Message> mes = new ArrayList<Message>();
//		for(MessageStatuss mm: mst){
//			mes.add(mm.getMessage());
//		System.out.println(mm.getLabel().getName());
//		}
//		System.out.println("Message n = "+mes.size());
//		for(Message mesage: mes){
//			System.out.println("Message body = "+mesage.getBody());
//		}
        return "profileform";
    }

    // Process the form.
    @RequestMapping(method = RequestMethod.POST)
    public String processEditProfile(
            @ModelAttribute("profile") @Valid ProfileForm editProfile,
            BindingResult result) {

        editProfileValidation.validate(editProfile, result);

        if (result.hasErrors()) {
            return "profileform";
        } else {

            User user = userService.getUser(SecurityContextHolder.getContext()
                    .getAuthentication().getName());


            userService.update(editProfile.updateUser(user));

            return "profileform";
        }

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Country.class, countryEditor);
    }

    @ModelAttribute("countryList")
    public List<Country> populateCountryList() {

        return countryService.getAllCountry();
    }


}
