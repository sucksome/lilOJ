package suck.some.lilOJ.user;

import java.security.Principal;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
    private final JdbcUserDetailsManager userDetailsManager;

    public UserController(JdbcUserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @PostMapping("/u/changePassword")
    public void changeUserPassword(@RequestBody ChangePasswordBody changePasswordBody, Principal principal) {
        if (principal == null) {
            throw new RuntimeException("Not logged in");
        }
        userDetailsManager.changePassword(changePasswordBody.oldPassword(), changePasswordBody.newPassword());
    }

}

record ChangePasswordBody(String oldPassword, String newPassword) {
}