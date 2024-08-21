package com.meal360.web.userDetails.service;

import com.meal360.web.Users.model.Users;
import com.meal360.web.Users.repository.UserRepository;
import com.meal360.web.userDetails.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{

        //userRepository.save(new Users("admin","admin", true, "ADMIN"));
        Optional<Users> user = userRepository.findByUserName(userName);

        user.orElseThrow( () -> new UsernameNotFoundException("Not Found:" + userName));

        return user.map(MyUserDetails::new).get();
    }
}
