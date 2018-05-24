package awantunai.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import awantunai.test.constant.AppConstant;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	Logger log = LoggerFactory.getLogger(ResourceServerConfiguration.class);

	@Value("${security.oauth2.resource.id:Sidapdap!@#}")
	String resourceId;

	@Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(resourceId);
    }

	@Override
    public void configure(HttpSecurity http) throws Exception {
    http
    	.authorizeRequests()
    	.antMatchers(AppConstant.SWAGGER_URL_WHITELIST).permitAll()
    	.antMatchers("/user/register").permitAll()
    	.antMatchers("/**").authenticated();
	}
}
