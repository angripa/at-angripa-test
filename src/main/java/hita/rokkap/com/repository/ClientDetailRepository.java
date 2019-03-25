package hita.rokkap.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hita.rokkap.com.domain.OauthClientDetails;

/**
* @Author  : angripa
* @Date    : Apr 24, 2018
* 
**/
public interface ClientDetailRepository extends JpaRepository<OauthClientDetails, String>{
	OauthClientDetails findByClientId(String clientId);
	
	OauthClientDetails deleteByClientId(String clientId);
}


