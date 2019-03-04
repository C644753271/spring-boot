package com.duqio.boot.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "shiro_role")
public class ShiroRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private Integer id;
 
    private String role;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
            @JoinColumn(name = "pid") })
    private List<ShiroPermission> permissions;
    
    @ManyToMany
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
            @JoinColumn(name = "uid") })
    private List<ShiroUser> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<ShiroPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<ShiroPermission> permissions) {
		this.permissions = permissions;
	}

	public List<ShiroUser> getUsers() {
		return users;
	}

	public void setUsers(List<ShiroUser> users) {
		this.users = users;
	}
	    
}
