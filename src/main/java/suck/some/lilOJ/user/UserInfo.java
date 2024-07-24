package suck.some.lilOJ.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
// import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_info")
public record UserInfo(
        @Id String username,
        String country,
        String about,
        @Version Integer version) {
}
