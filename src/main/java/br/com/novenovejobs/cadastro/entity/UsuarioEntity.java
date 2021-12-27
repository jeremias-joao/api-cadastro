package br.com.novenovejobs.cadastro.entity;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "rg")
	private String rg;
	@Column(name = "telefone")
	private String celular;
	@Column(name = "email")
	private String email;
	@Column(name ="endereço")
	private String endereco;
	
	public UsuarioEntity() {

	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, endereco, id, nome, rg, celular);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(rg, other.rg)
				&& Objects.equals(celular, other.celular);
	}
	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + celular
				+ ", email=" + email + ", endereco=" + endereco + "]";
	}
	public UsuarioEntity(String nome, String cpf, String rg, String telefone, String email, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.celular = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	

}
