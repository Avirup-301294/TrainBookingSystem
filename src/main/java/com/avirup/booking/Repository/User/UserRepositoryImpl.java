package com.avirup.booking.Repository.User;

import com.avirup.booking.Model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final Map<Integer, User> userMap = new HashMap<>();
    private final List<User> usersList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);
    public UserRepositoryImpl() {
        usersList.add(new User(idCounter.incrementAndGet(), "Avirup", "Mondal", "avirupmondal1994@gmail.com"));
        usersList.add(new User(idCounter.incrementAndGet(), "Monisha", "Dev", "monishadev95@gmail.com"));
        usersList.add(new User(idCounter.incrementAndGet(), "Ankita", "Mondal", "ann.mondal965@gmail.com"));
        usersList.add(new User(idCounter.incrementAndGet(), "Animesh", "Mondal", "manimesh65@gmail.com"));

        for (User user : usersList) {
            userMap.put(Math.toIntExact(user.getId()), user);
        }
    }

    @Override
    public User createUser(User user) {
        long newId = idCounter.incrementAndGet();
        user.setId(newId);
        userMap.put((int) newId, user);
        usersList.add(user);
        return user;
    }

    /*
        Update will update user on both the map and the list
        UserId won't update. The same userId will be used.
     */
//    @Override
//    public User updateUser(User user) {
//        int key = 0;
//
//        for(Map.Entry<Integer, User> users: userMap.entrySet()) {
//            if(users.getValue().getId().equals(user.getId())) {
//                key = users.getKey();
//                userMap.put(key, user);
//            }
//        }
//        int idx = 0;
//        for(User u: usersList) {
//            if(u.getId().equals(user.getId())) {
//                User usr = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
//                usersList.remove(idx);
//                usersList.add(usr);
//            }
//            idx++;
//        }
//        return userMap.get(key);
//    }
    @Override
    public User updateUser(User user) {
        int key = 0;

        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            if (entry.getValue().getId().equals(user.getId())) {
                key = entry.getKey();
                userMap.put(key, user);
            }
        }

        for (User u : usersList) {
            if (u.getId().equals(user.getId())) {
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setEmail(user.getEmail());
            }
        }

        return userMap.get(key);
    }
    @Override
    public List<User> findAll() {
        System.out.println(usersList);
        return usersList;
    }

    @Override
    public User getUser(Long id) {
        User user = null;
        for(Map.Entry<Integer,User> entry: userMap.entrySet()) {
            if(entry.getValue().getId().equals(id)) {
                user = entry.getValue();
                System.out.println(user);
                return user;
            }
        }

        return user;
    }

    /*
        Delete will delete the user from both Map and List
     */
    @Override
    public String deleteById(Long userId) {
        // Deleting from userMap
        for(Map.Entry<Integer, User> users: userMap.entrySet()) {
            if(users.getValue().getId().equals(userId)) {
                userMap.remove(users.getKey());
            }
        }

        // Deleting from userList
        int idx = 0;
        for(User u: usersList) {
            if(u.getId().equals(userId)) {
                usersList.remove(idx);
            }
            idx++;
        }

        return "User Id: " + idx + " deleted!";
    }
}
