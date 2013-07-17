package ru.t_systems.demail.service;

import ru.t_systems.demail.model.user.User;

public interface UserService {

    public User getUser(String login);

    public void addUser(User user);

    public boolean isRegistred(String login);

    public void update(User user);

    @Deprecated
    public void deleteUser(User user);
}
