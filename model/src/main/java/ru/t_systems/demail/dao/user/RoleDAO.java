package ru.t_systems.demail.dao.user;

import ru.t_systems.demail.model.user.Role;

public interface RoleDAO {

    public Role getRole(int id);

    public void saveRole(Role role);

}
