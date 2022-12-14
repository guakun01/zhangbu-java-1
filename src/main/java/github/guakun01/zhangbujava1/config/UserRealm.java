package github.guakun01.zhangbujava1.config;

import java.util.Objects;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import github.guakun01.zhangbujava1.manager.GuaManager;
import github.guakun01.zhangbujava1.model.common.GuaBO;

@Component
public class UserRealm extends AuthorizingRealm {

    private GuaManager guaManager;

    @Autowired
    public UserRealm(
        GuaManager guaManager,
        HashedCredentialsMatcher matcher
    ) {
        super(matcher);
        this.guaManager = guaManager;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String gname = (String) token.getPrincipal();
        String gid = new String((char[]) token.getCredentials()) ;
        // 判空
        GuaBO guaBO = guaManager.getGuaByName(gname);
        String salt = guaBO.getSalt();

        // if (Objects.isNull(guaBO)) {
        //     throw new UnknownAccountException(String.format("The gname(%s) is a void.", gname));
        // }

        // // check pw
        // String pwInDb = guaBO.getInnerId();
        // if (!gid.equals(pwInDb)) {
        //     throw new IncorrectCredentialsException(String.format("Use wrong id for gname(%s) .", gname));
        // }

        return new SimpleAuthenticationInfo(guaBO.getDisplayName(), guaBO.getInnerId(), ByteSource.Util.bytes(salt), this.getName());
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}
