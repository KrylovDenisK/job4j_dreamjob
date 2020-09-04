package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static final Store INST = new MemStore();
    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private Map<Integer, User> users = new ConcurrentHashMap<>();
    private static AtomicInteger postId = new AtomicInteger(4);
    private static AtomicInteger candidateId = new AtomicInteger(4);
    private static AtomicInteger userId = new AtomicInteger(4);

    private MemStore() {
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<User> findAllUsers() {
        return users.values();
    }

    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(postId.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(candidateId.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public User findByEmail(String email, String password) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        if (user.getId() == 0) {
            user.setId(userId.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public List<City> getCities() {
        return null;
    }
}
