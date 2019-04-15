package fr.formation.entities;
// Generated 15 avr. 2019 13:33:11 by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Solution generated by hbm2java
 */
@Entity
@Table(name = "solution", catalog = "debugathor")
public class Solution implements java.io.Serializable {

	private Integer idSolution;
	private Logiciel logiciel;
	private String type;
	private Date dateBug;
	private String titre;
	private String description;
	private String demarche;
	private String technologie;
	private Set<Proposition> propositions = new HashSet<Proposition>(0);

	public Solution() {
	}

	public Solution(Logiciel logiciel, String titre, String description, String demarche, String technologie) {
		this.logiciel = logiciel;
		this.titre = titre;
		this.description = description;
		this.demarche = demarche;
		this.technologie = technologie;
	}

	public Solution(Logiciel logiciel, String type, Date dateBug, String titre, String description, String demarche,
			String technologie, Set<Proposition> propositions) {
		this.logiciel = logiciel;
		this.type = type;
		this.dateBug = dateBug;
		this.titre = titre;
		this.description = description;
		this.demarche = demarche;
		this.technologie = technologie;
		this.propositions = propositions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idSolution", unique = true, nullable = false)
	public Integer getIdSolution() {
		return this.idSolution;
	}

	public void setIdSolution(Integer idSolution) {
		this.idSolution = idSolution;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Logiciel_idLogiciel", nullable = false)
	public Logiciel getLogiciel() {
		return this.logiciel;
	}

	public void setLogiciel(Logiciel logiciel) {
		this.logiciel = logiciel;
	}

	@Column(name = "Type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateBug", length = 10)
	public Date getDateBug() {
		return this.dateBug;
	}

	public void setDateBug(Date dateBug) {
		this.dateBug = dateBug;
	}

	@Column(name = "Titre", nullable = false, length = 45)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "Description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Demarche", nullable = false)
	public String getDemarche() {
		return this.demarche;
	}

	public void setDemarche(String demarche) {
		this.demarche = demarche;
	}

	@Column(name = "Technologie", nullable = false, length = 45)
	public String getTechnologie() {
		return this.technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "solution")
	public Set<Proposition> getPropositions() {
		return this.propositions;
	}

	public void setPropositions(Set<Proposition> propositions) {
		this.propositions = propositions;
	}

}
