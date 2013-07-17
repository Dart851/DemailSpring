package ru.t_systems.demail.service;

import ru.t_systems.demail.model.user.Role;

public interface RoleService {

    public Role getRole(int id);

    public void saveRole(Role role);
}
