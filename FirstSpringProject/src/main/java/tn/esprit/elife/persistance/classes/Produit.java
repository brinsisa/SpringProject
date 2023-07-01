package tn.esprit.elife.persistance.classes;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Produit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	 Long idProduit; // ClÃ© primaire
	 String codeProduit;
	 String libelleProduit;
	 float prixUnitaire;
	@OneToOne
	 DetailsProduit DetailsP;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	 Set<DetailsFacture> detailsF;
	 @ManyToOne
		Stock stock;
	 @ManyToOne
		Rayon rayon;
	 @ManyToMany(cascade = CascadeType.ALL)
	 Set<Fournisseur> fournisseurs;
	
}
