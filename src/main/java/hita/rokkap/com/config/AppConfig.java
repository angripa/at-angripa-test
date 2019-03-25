package hita.rokkap.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
* @Author  : angripa
* @Date    : Apr 17, 2018
* 
**/
@Configuration
@EnableJpaAuditing(auditorAwareRef = "appAuditorAware", modifyOnCreate = true)
public class AppConfig {

}


