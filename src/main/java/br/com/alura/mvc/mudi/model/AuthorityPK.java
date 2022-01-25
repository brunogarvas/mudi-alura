package br.com.alura.mvc.mudi.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AuthorityPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -826692822454030791L;

	private String username;
	
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}