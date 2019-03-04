package com.duqio.boot.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "shiro_user")
public class ShiroUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
    @GeneratedValue
    private Integer shiroId;
	
    private String shiroUsername;
    
    private String shiroPassword;
    
    private String shiroSalt;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
            @JoinColumn(name = "rid") })
    private List<ShiroRole> roles;

	public Integer getShiroId() {
		return shiroId;
	}

	public void setShiroId(Integer shiroId) {
		this.shiroId = shiroId;
	}

	public String getShiroUsername() {
		return shiroUsername;
	}

	public void setShiroUsername(String shiroUsername) {
		this.shiroUsername = shiroUsername;
	}

	public String getShiroPassword() {
		return shiroPassword;
	}

	public void setShiroPassword(String shiroPassword) {
		this.shiroPassword = shiroPassword;
	}

	public String getShiroSalt() {
		return shiroSalt;
	}

	public void setShiroSalt(String shiroSalt) {
		this.shiroSalt = shiroSalt;
	}

	public List<ShiroRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ShiroRole> roles) {
		this.roles = roles;
	}
	
	public String getCredentialsSalt() {
        return shiroUsername + shiroSalt + shiroSalt;
    }

	
}
