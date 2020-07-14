package ru.job4j.dream.mockito;

import ru.job4j.dream.model.User;

import java.util.List;

public class ValidateService implements Validate {
    private static final Validate INST = new ValidateService();
    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public static Validate getInstance() {
        return INST;
    }
}
