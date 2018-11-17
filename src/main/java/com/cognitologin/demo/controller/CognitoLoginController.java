package com.cognitologin.demo.controller;

import com.cognitologin.demo.model.request.ClientCredential;
import com.cognitologin.demo.model.response.StatusResponse;
import com.cognitologin.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CognitoLoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST, produces = { "application/json; charset=UTF-8" })
    public ResponseEntity login(@RequestBody ClientCredential credentials) throws Exception  {
        String retorno = authenticationService.LoginUser(credentials);
        return new ResponseEntity<>(new StatusResponse(HttpStatus.OK.value(),retorno), HttpStatus.OK);
    }
}
