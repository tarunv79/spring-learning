package spring.practice.udemy.springlearningudemy;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserRepository {

    protected static List<User> users = new ArrayList<>();
    protected static AtomicInteger idGenerator;

    static {
        idGenerator = new AtomicInteger(0);
        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,Calendar.DECEMBER,24,4,30,2);
        Date date = calendar.getTime();
        users.add(new User("Default", date.toString()));
    }

    public User save(User user){
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
        return user;
    }

    public List<User> getUsers(){
        return users;
    }

    public Optional<User> getUser(int id){
        return users.stream().filter(u-> u.getId()==id).findFirst();
    }
}
