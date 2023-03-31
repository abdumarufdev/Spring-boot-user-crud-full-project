package com.example.useradd.Servise;

import com.example.useradd.Entity.Users;
import com.example.useradd.Payload.ApiResponse;
import com.example.useradd.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiselmpl implements UserServise{
    @Autowired
    UserRepository userRepository;
    @Override
    public ApiResponse adduser(String firstname, String lastname, String date) {

        if (userRepository.existsByFirstnameAndLastname(firstname,lastname)) return new ApiResponse(false,"Bunday foydalanuvchi mavjud;");

        Users users = new Users();
        users.setFirstname(firstname);
        users.setLastname(lastname);
        users.setDate(date);

        userRepository.save(users);
        return new ApiResponse(true,"Malumot saqlandi!");
    }

    @Override
    public ApiResponse deleteUser(Integer id) {
        boolean b = userRepository.existsById(id);
        if (!b) return new ApiResponse(false,"User topilmadi!");
        userRepository.deleteById(id);
        return new ApiResponse(true,"Malumot o'chirildi");
    }

    @Override
    public ApiResponse editeUser(String firstname, String lastname, String date, Integer id) {

        if (!userRepository.existsById(id)) return new ApiResponse(false,"Bunday user topilmadi");

        Optional<Users> usersOptional = userRepository.findById(id);
        List<Users> usersList = userRepository.findAll();

        for (Users users : usersList){
            if (!users.getId().equals(id)){
                if (users.getFirstname().equals(firstname) && users.getLastname().equals(lastname)) return new ApiResponse(false,"Bunday user mavjud");
            }
        }

        Users users = usersOptional.get();
        users.setFirstname(firstname);
        users.setLastname(lastname);
        users.setDate(date);

        userRepository.save(users);
        return new ApiResponse(true,"Malumot tahirlandi!");
    }
}
