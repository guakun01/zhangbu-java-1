package github.guakun01.zhangbujava1.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String gname = (String) token.getPrincipal();
        String gid = new String((char[]) token.getCredentials()) ;
        // 判空
        if (StringUtils.isEmpty(gname) || StringUtils.isEmpty(gid)) {
            throw new UnknownAccountException(String.format("The gname(%s) is a void.", gname));
        }
        if (StringUtils.isEmpty(gname) || StringUtils.isEmpty(gid)) {
            throw new IncorrectCredentialsException(String.format("Use wrong id gname(%s) .", gname));
        }

        return new SimpleAuthenticationInfo(gname, gid, this.getName());

    }

}
