package com.example.useradd.Controller;

import com.example.useradd.Payload.ApiResponse;
import com.example.useradd.Servise.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class AddController {

    @Autowired
    UserServise userServise;

    @PostMapping("/add/user")
    public @ResponseBody ResponseEntity<?> addUser(@RequestParam("firsname") String firstname,
                                                   @RequestParam("lastname") String lastname,
                                                   @RequestParam("date") String date ){
        ApiResponse apiResponse =userServise.adduser(firstname,lastname,date);
        return ResponseEntity.status(apiResponse.isSuccess()?200:208).body(apiResponse.getMessage());
    }

    @DeleteMapping("/delete/user/{id}")
    public HttpEntity<?> deleteUser(@PathVariable Integer id){
        ApiResponse apiResponse = userServise.deleteUser(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:208).body(apiResponse.isSuccess());
    }

    @PutMapping("/edite/user")
    public @ResponseBody ResponseEntity<?> editeUser(@RequestParam("editFirstname") String firstname,
                                                     @RequestParam("editeLastname") String lastname,
                                                     @RequestParam("editeDate") String date,
                                                     @RequestParam("editeId") Integer editeId

                                                     ){
        ApiResponse apiResponse = userServise.editeUser(firstname,lastname,date,editeId);
        return ResponseEntity.status(apiResponse.isSuccess()?200:208).body(apiResponse.getMessage());
    }
}
