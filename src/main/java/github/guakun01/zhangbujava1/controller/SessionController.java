package github.guakun01.zhangbujava1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.guakun01.zhangbujava1.manager.SessionManager;

@RestController
public class SessionController {

    SessionManager sessionManager;

    @Autowired
    public SessionController(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @PostMapping("/login")
    public String login(@RequestParam("gname") String gname,
        @RequestParam("gid") String gid) {
            return sessionManager.login(gname, gid);
        }

    @PostMapping("/logout")
    public void logout() {}
}
