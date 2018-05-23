package awantunai.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.google.common.collect.Lists;

import awantunai.test.exception.AppAuthException;


@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {
	Logger LOG = LoggerFactory.getLogger(OAuth2Configuration.class);
	@Value("${security.oauth2.resource.jwt.signing-key:SidapdapJWTKey}")
	private String signingKey;
	
	@Autowired
	CustomClientDetailsService customClientDetailsService;
	@Autowired
	JwtAccessTokenConverter accessTokenConverter;	
	@Autowired
	TokenStore tokenStore;

	@Autowired
	CustomUserDetailsService customUserDetailsService;
	@Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {        
    	clients.withClientDetails(customClientDetailsService);
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).userDetailsService(customUserDetailsService)
        	.tokenStore(tokenStore)
        	.tokenEnhancer(tokenEnhancerChain())
        	.exceptionTranslator(e -> {
                if (e instanceof OAuth2Exception) {
                    OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
                    return ResponseEntity
                            .status(oAuth2Exception.getHttpErrorCode())
                            .body(new AppAuthException(oAuth2Exception.getMessage()));
                } else if(e instanceof InternalAuthenticationServiceException) {
                	 	return ResponseEntity
                             .status(HttpStatus.UNAUTHORIZED.value())
                             .body(new AppAuthException(""));
                } else {
                    throw e;
                }
            });
    }    

    
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
    @Bean
    public TokenEnhancerChain tokenEnhancerChain(){
        final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Lists.newArrayList(tokenEnhancer(), accessTokenConverter));
        return tokenEnhancerChain;
    }

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
		return converter; 
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());

	}

	@Bean
	@Primary // Making this primary to avoid any accidental duplication with another token service instance of the same name
	public ResourceServerTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}
}