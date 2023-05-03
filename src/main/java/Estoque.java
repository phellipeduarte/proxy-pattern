import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private static Map<Integer, Produto> produtos = new HashMap<>();

    public static Produto getProduto(Integer id){ return produtos.get(id); }

    public static Integer obterQuantidade(Produto produto){
        Integer quantidade = 0;

        for(Map.Entry<Integer, Produto> produtoEntry : produtos.entrySet()){
            var nome = produtoEntry.getValue().getNome();
            if(nome.equals(produto.getNome())){
                quantidade++;
            }
        }

        return quantidade;

    }

    public static void addProduto(Produto produto){ produtos.put(produto.getId(), produto); }
}
