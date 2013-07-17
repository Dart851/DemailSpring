package ru.t_systems.demail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.t_systems.demail.dao.user.RoleDAO;
import ru.t_systems.demail.model.user.Role;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

    public void saveRole(Role role) {
        roleDAO.saveRole(role);

    }

}
