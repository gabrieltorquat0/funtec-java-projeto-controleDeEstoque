package edu.funtec.controleDeEstoque.entity;

import java.math.BigDecimal; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor; 
import lombok.Getter; 
import lombok.NoArgsConstructor; 
import lombok.Setter;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cliente { 
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "O endereco não pode estar em branco")
    private String endereco;

    @NotBlank(message = "O email não pode estar em branco")
    private String email;

    @NotBlank(message = "O CPF/CNPJ não pode estar em branco")
    private String cpfOrCNPJ;

    // private BigDecimal preco;
  
}

