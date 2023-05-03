import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Arrays;


public class AlunoProxyTest {

    @BeforeEach
    void setUp(){
        LocalDate dataFabricacao = LocalDate.of(2023, 03, 22);
        LocalDate dataValidade = LocalDate.of(2023, 05, 22);
        Estoque.addProduto(new Produto(1, "Chocolate Lacta", 9.90f, "1A2B3C", dataFabricacao, dataValidade, "Juiz de Fora", "Lacta"));
        Estoque.addProduto(new Produto(2, "Chocolate Lacta", 9.90f, "1A2B3C", dataFabricacao, dataValidade, "Juiz de Fora", "Lacta"));
        Estoque.addProduto(new Produto(3, "Chocolate Lacta", 9.90f, "1A2B3C", dataFabricacao, dataValidade, "Juiz de Fora", "Lacta"));
        Estoque.addProduto(new Produto(4, "Chocolate Lacta", 9.90f, "1A2B3C", dataFabricacao, dataValidade, "Juiz de Fora", "Lacta"));
        Estoque.addProduto(new Produto(5, "Pão de Queijo", 15.90f, "1B12P4", dataFabricacao, dataValidade, "Bicas", "Forno de Minas"));
    }

    @Test
    void deveRetornarDadosProdutoChocolate(){
        ProdutoProxy produto = new ProdutoProxy(1);
        assertEquals(Arrays.asList("Chocolate Lacta", "9.9", "2023-05-22"), produto.obterDadosProduto());
    }

    @Test
    void deveRetornarDadosProdutoPaoQueijo(){
        ProdutoProxy produto = new ProdutoProxy(5);
        assertEquals(Arrays.asList("Pão de Queijo", "15.9", "2023-05-22"), produto.obterDadosProduto());
    }

    @Test
    void deveRetornarCapitalProdutoChocolate(){
        Funcionario funcionario = new Funcionario("Pietro", true);
        ProdutoProxy produto = new ProdutoProxy(3);
        assertEquals(39.60f, produto.obterCapital(funcionario), 0.01f);
    }

    @Test
    void deveRetornarCapitalProdutoPaoQueijo(){
        Funcionario funcionario = new Funcionario("Pietro", true);
        ProdutoProxy produto = new ProdutoProxy(5);
        assertEquals(15.90f, produto.obterCapital(funcionario), 0.01f);
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAdministrador(){
        try {
            Funcionario funcionario = new Funcionario("Oswaldo", false);
            ProdutoProxy produto = new ProdutoProxy(4);
            produto.obterCapital(funcionario);
            fail();
        }
        catch (IllegalArgumentException exception){
            assertEquals("Funcionário não é administrador", exception.getMessage());
        }
    }
}
