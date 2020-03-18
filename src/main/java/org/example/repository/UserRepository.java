package org.example.repository;


import com.techprimers.spring_boot_soap_example.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserRepository {
    private static final List<User> users= new ArrayList<>();

    @PostConstruct
    public void init(){
        User user1 = new User();
        user1.setEmpId(0);
        user1.setName("Sacha");
        user1.setSalary(120000.00);
        users.add(user1);

        User user2 = new User();
        user2.setEmpId(1);
        user2.setName("Vlad");
        user2.setSalary(140000.00);
        users.add(user2);

        User user3 = new User();
        user3.setEmpId(2);
        user3.setName("Dima");
        user3.setSalary(150000.00);
        users.add(user3);
    }
    public User findUser (int id){
        System.out.println("in method "+users.get(id).getEmpId());
        return users.get(id);
    }
    public List<User> userList (){
        return users;
    }


}
