package br.com.house.house.adapter.persistence.entity;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "house_person")
public class PersonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="family_id", referencedColumnName="id", nullable=false)
  private FamilyEntity family;

  @Column(name = "age", nullable = false)
  private int age;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "document_number")
  private String documentNumber;

  @Column(name = "salary_income")
  private BigDecimal salaryIncome;
}
