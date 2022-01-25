package br.com.alura.mvc.mudi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

	@EmbeddedId
	private AuthorityPK autorityPK;

	public AuthorityPK getAutorityPK() {
		return autorityPK;
	}

	public void setAutorityPK(AuthorityPK autorityPK) {
		this.autorityPK = autorityPK;
	}
		
}