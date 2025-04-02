package backcore.services;

import backcore.entities.UserEntity;
import backcore.jpa_repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserJpaRepository userJpaRepository;

    public List<UserEntity> getUsers() {
        return userJpaRepository.findAll();
    }

}
