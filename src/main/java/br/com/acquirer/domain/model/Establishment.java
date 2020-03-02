package br.com.acquirer.domain.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "establishment",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"merchant_code"})})
public class Establishment extends BaseEntity {

  private static final long serialVersionUID = 2311607522933786051L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  @Column(name = "name")
  private String name;

  @Column(name = "merchant_code")
  private Long merchantCode;

  @Column(name = "merchant_discount_rate")
  private Double MDR;

  @ManyToOne
  @JoinColumn(columnDefinition = "acquirer_uuid", referencedColumnName = "uuid",
      foreignKey = @ForeignKey(name = "fk_acquirer_uuid"))
  private Acquirer acquirer;

  public Establishment(String name, Long merchantCode, Acquirer acquirer, Double MDR) {
    this.name = name;
    this.merchantCode = merchantCode;
    this.acquirer = acquirer;
    this.MDR = MDR;
  }

  @SuppressWarnings("unused")
  private Establishment() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getMerchantCode() {
    return merchantCode;
  }

  public void setMerchantCode(Long merchantCode) {
    this.merchantCode = merchantCode;
  }

  public Acquirer getAcquirer() {
    return acquirer;
  }

  public void setAcquirer(Acquirer acquirer) {
    this.acquirer = acquirer;
  }

  public UUID getUuid() {
    return uuid;
  }

  public Double getMDR() {
    return MDR;
  }

  public void setMDR(Double mDR) {
    MDR = mDR;
  }

}
