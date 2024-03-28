package service;

import model.User;

import repositories.UserRepositories;
import repository.IUserRepositories;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {

    IUserRepositories userRepositories = new UserRepositories();
    public void insertUser(User newUser) throws SQLException {
        userRepositories.insertUser(newUser);
    }

    @Override
    public User selectUser(int id) {
        return userRepositories.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepositories.selectAllUsers();
    }


    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepositories.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepositories.updateUser(user);
    }
}
