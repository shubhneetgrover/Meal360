package com.meal360.web.autheticate.controller;

import com.meal360.web.autheticate.model.AuthenticateRequest;
import com.meal360.web.autheticate.model.AuthenticationResponse;
import com.meal360.web.userDetails.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class authenticateControllerV1 {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;


    @Autowired
    private com.meal360.web.util.jwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticateRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

}

