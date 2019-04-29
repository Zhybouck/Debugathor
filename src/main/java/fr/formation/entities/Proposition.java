package fr.formation.entities;
// Generated 15 avr. 2019 13:33:11 by Hibernate Tools 5.1.10.Final

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * Proposition generated by hbm2java
 */
@Entity
@Table(name = "proposition", catalog = "debugathor")
public class Proposition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PropositionId id;
	private Solution solution;
	private Utilisateur utilisateur;
	private Date dateProp;
	private String commentaire;
	private Integer note;

	public Proposition() {
	}

	public Proposition(PropositionId id, Solution solution, Utilisateur utilisateur) {
		this.id = id;
		this.solution = solution;
		this.utilisateur = utilisateur;
	}

	public Proposition(PropositionId id, Solution solution, Utilisateur utilisateur, Date dateProp, String commentaire,
			Integer note) {
		this.id = id;
		this.solution = solution;
		this.utilisateur = utilisateur;
		this.dateProp = dateProp;
		this.commentaire = commentaire;
		this.note = note;
	}



	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "utilisateurIdUtilisateur", column = @Column(name = "utilisateur_IdUtilisateur", nullable = false)),
			@AttributeOverride(name = "solutionIdSolution", column = @Column(name = "solution_idSolution", nullable = false)) })
	public PropositionId getId() {
		return this.id;
	}

	public void setId(PropositionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "solution_idSolution", nullable = false, insertable = false, updatable = false)
	public Solution getSolution() {
		return this.solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utilisateur_IdUtilisateur", nullable = false, insertable = false, updatable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Prop", length = 10)
	public Date getDateProp() {
		return this.dateProp;
	}

	public void setDateProp(Date dateProp) {
		this.dateProp = dateProp;
	}
	@Size(min=1,max=500)
	@Column(name = "Commentaire", length = 500)
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Column(name = "Note")
	public Integer getNote() {
		return this.note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
	

}
