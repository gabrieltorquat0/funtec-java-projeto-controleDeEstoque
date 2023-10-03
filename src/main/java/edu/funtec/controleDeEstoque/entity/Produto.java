package edu.funtec.controleDeEstoque.entity;

import java.math.BigDecimal; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor; 
import lombok.Getter; 
import lombok.NoArgsConstructor; 
import lombok.Setter;
import lombok.Data;

@Entity
@Table(name = "tb_produtos")
@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Produto { 
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O tipo de produto não pode estar em branco")
    private String tipoProduto;

    @NotBlank(message = "A descrição não pode estar em branco")
    private String descricao;

    @NotNull(message = "A quantidade não pode estar em branco")
    private int quantidade;

    @NotNull(message = "O preco não pode estar em branco")
    private BigDecimal preco;

    // @NotBlank(message = "O link da imagem não pode estar em branco")
    // private String imagem;
}

