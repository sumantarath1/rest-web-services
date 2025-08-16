package rest_web_services.service;

import org.springframework.stereotype.Component;
import rest_web_services.entity.User;
import rest_web_services.exception.UserNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {

    private User user;
    private static int index=0;

    static List<User> userList=new ArrayList<>();

    static{
        userList.add(new User(++index,"sumanta", LocalDate.now().minusYears(31)));
        userList.add(new User(++index,"swagata", LocalDate.now().minusYears(29)));
        userList.add(new User(++index,"dipankar", LocalDate.now().minusYears(28)));

    }
    public void addUser(User  user){
        user.setId(++index);
        userList.add(user);
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public Optional<User> findUserById(String id) throws UserNotFoundException {


        return Optional.ofNullable(userList.stream()
                .filter(user1 -> String.valueOf(user1.getId()).equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id)));
    }

    public void deleteUser(String id) {
        userList.removeIf(user -> String.valueOf(user.getId()).equalsIgnoreCase(id));
    }
}
