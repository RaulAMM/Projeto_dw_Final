package Bus.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private CardType type;
	private String id;
	private boolean status = false;
	private Double saldo;
	private String NomeTitular;
	private String userCPF;
			
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public String getNomeTitular() {
		return NomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		NomeTitular = nomeTitular;
	}
	public String getUserCPF() {
		return userCPF;
	}
	public void setUserCPF(String userCPF) {
		this.userCPF = userCPF;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(id, other.id);
	}
	
}
