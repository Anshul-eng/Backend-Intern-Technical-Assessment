package Wishlist.Demo.Service;

import Wishlist.Demo.Entity.UserInfo;
import Wishlist.Demo.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String addUser(UserInfo userInfo) {
        Optional<UserInfo> existingUser = repository.findByName(userInfo.getName());
        if (existingUser.isPresent()) {
            return "User already exists";
        }

        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User Added to System ";
    }

    public Optional<UserInfo> getUserByUsername(String username) {
        return repository.findByName(username);
    }
}
