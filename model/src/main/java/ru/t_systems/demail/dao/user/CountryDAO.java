package ru.t_systems.demail.dao.user;

import ru.t_systems.demail.model.user.Country;

import java.util.List;


public interface CountryDAO {

    public Country getCountry(int id);

    public List<Country> getAllCountry();

    public Country getCountry(String name);

}
