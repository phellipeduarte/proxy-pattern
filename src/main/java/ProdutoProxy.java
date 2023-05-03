import java.util.List;

public class ProdutoProxy implements IProduto{

    private Produto produto;
    private Integer id;

    public ProdutoProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosProduto() {
        if(this.produto == null){
            this.produto = new Produto(this.id);
        }
        return this.produto.obterDadosProduto();
    }

    @Override
    public Float obterCapital(Funcionario funcionario) {
        if(!funcionario.isAdministrador()){
            throw new IllegalArgumentException("Funcionário não é administrador");
        }
        if(this.produto == null){
            this.produto = new Produto(this.id);
        }
        return this.produto.obterCapital(funcionario);
    }
}
