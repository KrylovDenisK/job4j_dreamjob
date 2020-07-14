package ru.job4j.dream.mockito;

import ru.job4j.dream.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateStub implements Validate {
    private Map<Integer, User> store = new HashMap<>();
    private int ids = 0;
    @Override
    public User add(User user) {
        user.setId(ids++);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(store.values());
    }
}
