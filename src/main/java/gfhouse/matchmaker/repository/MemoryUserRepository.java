/*package gfhouse.matchmaker.repository;

import gfhouse.matchmaker.domain.User;

import java.util.*;

public class MemoryUserRepository implements UserRepository{

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setIdx(++sequence);
        store.put(user.getIdx(), user);
        return user;
    }

    @Override
    public Optional<User> findByIdx(Long idx) {
        return Optional.ofNullable(store.get(idx));
    }

    @Override
    public Optional<User> findById(String id) {
        return store.values().stream().filter(user -> user.getId().equals(id)).findAny();
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        return store.values().stream().filter(user -> user.getNickname().equals(nickname)).findAny();
    }

    @Override
    public Optional<User> findByPassword(String password) {
        return store.values().stream().filter(user -> user.getPassword().equals(password)).findAny();
    }

    @Override
    public Optional<User> findByScore(Short score) {
        return store.values().stream().filter(user -> user.getScore().equals(score)).findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}*/
