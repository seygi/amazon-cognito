package com.cognitologin.demo.controller;

import com.cognitologin.demo.model.response.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CognitoLoginController {

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST, produces = { "application/json; charset=UTF-8" })
    public ResponseEntity login() {
        return new ResponseEntity<>(new StatusResponse(HttpStatus.OK.value(),"Greetings from Spring Boot!"), HttpStatus.OK);
    }
}
