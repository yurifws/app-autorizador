package br.com.app.autorizador.adapters.out.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_cartao")
public class CartaoEntity {

	@Id
	private Long numero;

	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private BigDecimal saldo;
	
	@PrePersist
	protected  void onPrePersist() {
		this.saldo = BigDecimal.valueOf(500);
	}

}
