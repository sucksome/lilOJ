package suck.some.lilOJ.user;

import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserInfoController {
    private final UserInfoRepository userInfoRepository;

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @GetMapping("/u/{username}")
    public UserInfo getUserInfo(@PathVariable String username) {
        return userInfoRepository.findById(username).orElse(null);
    }

    @PostConstruct
    public void init() {
        if (userInfoRepository.findByUsername("admin") == null)
            userInfoRepository.save(new UserInfo("admin", "India", "I am the admin", null));
    }

}
