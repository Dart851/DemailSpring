package ru.t_systems.demail.dao.user;

import ru.t_systems.demail.model.user.User;

public interface UserDAO {

    public User getUser(String login);

    public void addUser(User user);

    public void update(User user);

    public void deleteUser(User user);
}
