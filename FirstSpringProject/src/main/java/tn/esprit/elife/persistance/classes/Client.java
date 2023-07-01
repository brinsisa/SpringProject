package tn.esprit.elife.persistance.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	 Long idClient; // ClÃ© primaire
	 String nom;
	String prenom;
	 String email;
	 String password;


	@Temporal(TemporalType.DATE) private Date dateNaissance;

	@Enumerated(EnumType.STRING)
	 Profession profession;

	@Enumerated(EnumType.STRING)
	 CategorieClient categorieClient;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	 Set<Facture> facture;


	
}
