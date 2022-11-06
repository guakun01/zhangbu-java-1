package github.guakun01.zhangbujava1.manager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component
public class SessionManagerImpl implements SessionManager {

    @Override
    public String login(String gname, String gid) {
        // get subject
        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken uToken = new UsernamePasswordToken(gname, gid);
        subject.login(uToken);
        return "success";
    }
    
}
