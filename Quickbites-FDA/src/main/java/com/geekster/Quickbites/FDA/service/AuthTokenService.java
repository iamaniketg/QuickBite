package com.geekster.Quickbites.FDA.service;


import com.geekster.Quickbites.FDA.model.AuthenticationToken;
import com.geekster.Quickbites.FDA.repository.AuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
    @Autowired
    AuthTokenRepo authTokenRepo;
    public boolean authenticate(String email, String authTokenValue)    {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(authTokenValue);
        if(authToken == null)        {
            return false;
        }
        String tokenConnectedEmail = authToken.getFoodie().getFoodieEmail();
        return tokenConnectedEmail.equals(email);
    }
}
