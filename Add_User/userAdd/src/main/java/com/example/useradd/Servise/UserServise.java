package com.example.useradd.Servise;

import com.example.useradd.Payload.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServise {
    ApiResponse adduser(String firstname, String lastname, String date);

    ApiResponse deleteUser(Integer id);

    ApiResponse editeUser(String firstname, String lastname, String date, Integer editeId);
}
