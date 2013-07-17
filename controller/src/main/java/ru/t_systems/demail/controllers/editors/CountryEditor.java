package ru.t_systems.demail.controllers.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.t_systems.demail.service.CountryService;

import java.beans.PropertyEditorSupport;

@Component
public class CountryEditor extends PropertyEditorSupport {

    @Autowired
    private CountryService countryService;

    @Override
    public void setAsText(final String text) {

        if (!text.equals("NONE") && !text.isEmpty()) {

            setValue(countryService.getCountry(Integer.valueOf(text)));
        }
    }

}
