package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    
    private String nome_produto;

    private String cod_produto;

    public Produto build() {

        return Produto.builder()
                .nome_produto(nome_produto)
                .cod_produto(cod_produto)
                .build();
    }

}

