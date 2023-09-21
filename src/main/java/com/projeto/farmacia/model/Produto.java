package com.projeto.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	    
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "O nome do produto é obrigatório")
		@Size(min=5,max=50,message = "O nome do produto deve ter no minímo 5 caracteres e no máximo 50 caracteres")
		private String nome;
		
		@NotBlank(message = "A descrição do produto é obrigatório")
		@Size(min=5,max=30,message = "A descrição do produto deve ter no minímo 5 caracteres e no máximo 30 caracteres")
		private String descricao;
		
		@NotNull(message = "O atributo preço é Obrigatorio")
		@Column(precision = 10, scale = 2)
		private BigDecimal preco;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Usuario usuario;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

}
