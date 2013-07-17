package ru.t_systems.demail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.dao.user.CountryDAO;
import ru.t_systems.demail.model.user.Country;

import java.util.List;


@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Transactional(readOnly = true)
    public Country getCountry(int id) {
        return countryDAO.getCountry(id);
    }

    @Transactional(readOnly = true)
    public List<Country> getAllCountry() {
        return countryDAO.getAllCountry();
    }

    @Transactional(readOnly = true)
    public Country getCountry(String name) {
        return countryDAO.getCountry(name);

    }

}
