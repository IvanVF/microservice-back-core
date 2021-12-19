package backcore.services;

import backcore.entitys.UserEntity;
import backcore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

}
