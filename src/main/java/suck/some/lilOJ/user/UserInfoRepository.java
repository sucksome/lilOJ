package suck.some.lilOJ.user;

import org.springframework.data.repository.ListCrudRepository;

public interface UserInfoRepository extends ListCrudRepository<UserInfo, String> {
    UserInfo findByUsername(String username);
}
