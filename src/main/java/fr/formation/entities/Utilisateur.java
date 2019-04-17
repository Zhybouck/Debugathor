package fr.formation.entities;
// Generated 15 avr. 2019 13:33:11 by Hibernate Tools 5.1.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "utilisateur", catalog = "debugathor")
public class Utilisateur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idUtilisateur;
	private String mdp;
	private String prenom;
	private String nom;
	private Date dateInsc;
	private String poste;
	private String rang;
	
	@NotEmpty
	@Email
	private String mail;
	
	private Set<Proposition> propositions = new HashSet<Proposition>(0);

	public Utilisateur() {
	}

	public Utilisateur(String mdp, String prenom, String nom, Date dateInsc, String poste, String rang, String mail) {
		this.mdp = mdp;
		this.prenom = prenom;
		this.nom = nom;
		this.dateInsc = dateInsc;
		this.poste = poste;
		this.rang = rang;
		this.mail = mail;
	}

	public Utilisateur(String mdp, String prenom, String nom, Date dateInsc, String poste, String rang, String mail,
			Set<Proposition> propositions) {
		this.mdp = mdp;
		this.prenom = prenom;
		this.nom = nom;
		this.dateInsc = dateInsc;
		this.poste = poste;
		this.rang = rang;
		this.mail = mail;
		this.propositions = propositions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "IdUtilisateur", unique = true, nullable = false)
	public Long getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Column(name = "MDP", nullable = false, length = 45)
	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Column(name = "Prenom", nullable = false, length = 45)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "Nom", nullable = false, length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateInsc", nullable = false, length = 10)
	public Date getDateInsc() {
		return this.dateInsc;
	}

	public void setDateInsc(Date dateInsc) {
		this.dateInsc = dateInsc;
	}

	@Column(name = "Poste", nullable = false, length = 45)
	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	@Column(name = "Rang", nullable = false, length = 45)
	public String getRang() {
		return this.rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	@Column(name = "Mail", nullable = false, length = 45)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
	public Set<Proposition> getPropositions() {
		return this.propositions;
	}

	public void setPropositions(Set<Proposition> propositions) {
		this.propositions = propositions;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", mdp=" + mdp + ", prenom=" + prenom + ", nom=" + nom
				+ ", dateInsc=" + dateInsc + ", poste=" + poste + ", rang=" + rang + ", mail=" + mail
				+ ", propositions=" + propositions + "]";
	}

	
}
