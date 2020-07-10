package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();
    Collection<Candidate> findAllCandidates();
    Collection<User> findAllUsers();
    void savePost(Post post);
    void saveCandidate(Candidate candidate);
    Post findPostById(int id);
    Candidate findCandidateById(int id);
    User findByEmail(String email, String password);
    User saveUser(User user);
}
