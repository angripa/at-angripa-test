package awantunai.test.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="oauth_user")
public class User implements UserDetails, CredentialsContainer{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7155201239845704245L;
	
	@Id
	@Column(name="username")
    private String username;
	@Column(name="password")
	private String password;
	@Column(name="account_non_expired")
    private boolean accountNonExpired;
	@Column(name="account_non_locked")
    private boolean accountNonLocked;
	@Column(name="credentials_non_expired")
    private boolean credentialsNonExpired;
	@Column(name="enabled")
    private boolean enabled;

    public User() {
    }

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		List<GrantedAuthority> al = new ArrayList<>();
		
		return al;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	
}
