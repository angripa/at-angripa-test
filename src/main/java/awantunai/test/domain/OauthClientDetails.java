package awantunai.test.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : angripa
 * @Date : Apr 24, 2018
 * 
 **/
@Getter
@Setter
@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails implements ClientDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3940187870891338339L;
	@Id
	@Column(name = "client_id")
	private String clientId;
	@Column(name = "client_secret")
	private String clientSecret;
	@Column(name = "resource_ids")
	private String resourceIds;
	@Column(name = "scope")
	private String scope;
	@Column(name = "authorized_grant_types")
	private String authorizedGrantTypes;
	@Column(name = "web_server_redirect_uri")
	private String webServerRedirectUri;
	@Column(name = "access_token_validity_seconds")
	private Integer accessTokenValiditySeconds;
	@Column(name = "refresh_token_validity_seconds")
	private Integer refreshTokenValiditySeconds;
	@Column(name = "additional_information")
	private String additionalInformation;
	@Column(name = "autoapprove")
	private String autoapprove;
//	@Column(name = "authorities")
//	private String authorities;

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return accessTokenValiditySeconds;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return Collections.emptyMap();
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if(null == authorizedGrantTypes){
			return Collections.emptySet();
		}
		String[] values = authorizedGrantTypes.split(",");
		Set<GrantedAuthority> hashSet = new HashSet<>();
		for (String string : values) {
			hashSet.add(new SimpleGrantedAuthority(string));
		}
		 
		return hashSet;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		 
		if(null == authorizedGrantTypes){
			return Collections.emptySet();
		}
		String[] values = authorizedGrantTypes.split(",");
		Set<String> hashSet = new HashSet<String>(Arrays.asList(values));
		return hashSet;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return refreshTokenValiditySeconds;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub

		if(null == webServerRedirectUri){
			return Collections.emptySet();
		}
		String[] values = webServerRedirectUri.split(",");
		Set<String> hashSet = new HashSet<String>(Arrays.asList(values));
		return hashSet;
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		if(null == resourceIds){
			return Collections.emptySet();
		}
		String[] values = resourceIds.split(",");
		Set<String> hashSet = new HashSet<String>(Arrays.asList(values));
		return hashSet;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		if(null == scope){
			return Collections.emptySet();
		}
		String[] values = scope.split(",");
		Set<String> hashSet = new HashSet<String>(Arrays.asList(values));
		return hashSet;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		if (autoapprove == null) {
			return false;
		}
		if (autoapprove.equals("true") || scope.matches(autoapprove)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return this.scope != null && !this.scope.isEmpty();
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return this.clientSecret != null;
	}
}
