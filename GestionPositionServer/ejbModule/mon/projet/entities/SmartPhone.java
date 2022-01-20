package mon.projet.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SmartPhone
 *
 */
@Entity
public class SmartPhone implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imei;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@JoinColumn(name = "utilisateur_id")
	private User utilisateur;

	public SmartPhone() {
		super();
	}   

	public SmartPhone(int id, String imei, User utilisateur) {
		super();
		this.id = id;
		this.imei = imei;
		this.utilisateur = utilisateur;
	}

	public SmartPhone(String imei, User utilisateur) {
		super();
		this.imei = imei;
		this.utilisateur = utilisateur;
	}
	
	public SmartPhone(String imei) {
		super();
		this.imei = imei;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", imei=" + imei + ", utilisateur=" + utilisateur + "]";
	}
	
}