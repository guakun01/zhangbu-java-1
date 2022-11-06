package github.guakun01.zhangbujava1.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
  @Bean
  public SecurityManager securityManager(Realm realm) {
      return new DefaultWebSecurityManager(realm);
  }
  
  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    Map<String,String> shiroFilterDefinitationMap = new LinkedHashMap<String, String>();
    shiroFilterDefinitationMap.put( "/hi", "anon");
    shiroFilterDefinitationMap.put( "/login", "anon");
    shiroFilterDefinitationMap.put("/api/v1/gua/", "authc");
    shiroFilterDefinitationMap.put("/**", "authc");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterDefinitationMap);
    return shiroFilterFactoryBean;
  }
}
