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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(builderMethodName = "newBuilder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "acquirer", uniqueConstraints = {@UniqueConstraint(columnNames = {"cnpj"})})
public class Acquirer extends BaseEntity {

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
}
