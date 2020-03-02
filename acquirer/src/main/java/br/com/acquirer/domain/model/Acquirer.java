package br.com.acquirer.domain.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.acquirer.domain.utils.AcquirerName;

@Entity
@Table(name = "acquirer", uniqueConstraints = {@UniqueConstraint(columnNames = {"cnpj"})})
public class Acquirer extends BaseEntity {

  private static final long serialVersionUID = -2050662630073834452L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  @Enumerated(EnumType.STRING)
  @Column(name = "name")
  private AcquirerName acquirerName;

  @Column(name = "cnpj")
  private String cnpj;

  @OneToMany(mappedBy = "acquirer", fetch = FetchType.EAGER)
  private List<Establishment> establishments;

  public Acquirer(AcquirerName acquirerName, String cnpj) {
    this.acquirerName = acquirerName;
    this.cnpj = cnpj;
  }

  @SuppressWarnings("unused")
  private Acquirer() {}

  public AcquirerName getAcquirerName() {
    return acquirerName;
  }

  public void setAcquirerName(AcquirerName acquirerName) {
    this.acquirerName = acquirerName;
  }

  public List<Establishment> getEstablishments() {
    return establishments;
  }

  public void setEstablishments(List<Establishment> establishments) {
    this.establishments = establishments;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public UUID getUuid() {
    return uuid;
  }

}
