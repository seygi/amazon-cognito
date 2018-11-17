package com.cognitologin.demo.service;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidp.model.*;
import com.cognitologin.demo.config.CognitoConfig;
import com.cognitologin.demo.model.request.ClientCredential;
import org.apache.logging.log4j.util.Strings;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private CognitoConfig cognitoConfig;

    protected AWSCognitoIdentityProviderClient cognitoClient = new AWSCognitoIdentityProviderClient();

    public String LoginUser(ClientCredential credentials) throws Exception {
        System.out.println(credentials);

        CognitoHelper helper = new CognitoHelper(cognitoConfig.getCognitoUserPoolId(), cognitoConfig.getCognitoUserPoolClientId());

        String result = helper.ValidateUser(credentials.getEmail(), credentials.getPassword());
        if (result != null) {
            System.out.println("User is authenticated:" + result);
            JSONObject payload = CognitoJWTParser.getPayload(result);
            String provider = payload.get("iss").toString().replace("https://", "");

            //Credentials credentails = helper.GetCredentials(provider, result);


            return "User is authenticated:";
        } else {
            System.out.println("Username/password is invalid");


            return "Username/password is invalid";
        }

       /* Map<String, String> authParams = new HashMap<String, String>();
        authParams.put("USERNAME", credentials.getEmail());
        authParams.put("PASSWORD", credentials.getPassword());


        AdminInitiateAuthRequest authRequest = new AdminInitiateAuthRequest()
                .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                .withAuthParameters(authParams)
                .withClientId(cognitoConfig.getCognitoUserPoolClientId())
                .withUserPoolId(cognitoConfig.getCognitoUserPoolId());

        AdminInitiateAuthResult authResponse = cognitoClient.adminInitiateAuth(authRequest);
        if (Strings.isBlank(authResponse.getChallengeName())) {
            return "login invalido";
        } else if (ChallengeNameType.NEW_PASSWORD_REQUIRED.name().equals(authResponse.getChallengeName())) {
            return "precisa trocar a senha";
        } else {
            throw new RuntimeException("unexpected challenge on signin: " + authResponse.getChallengeName());
        }*/
    }
}
