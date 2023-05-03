import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Produto implements IProduto{

    private Integer id;
    private String nome;
    private Float preco;
    private String lote;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private String cidadeFabricacao;
    private String empresaFornecedora;

    public Produto(Integer id){
        this.id = id;
        Produto objeto = Estoque.getProduto(id);
        this.nome = objeto.nome;
        this.preco = objeto.preco;
        this.lote = objeto.lote;
        this.dataFabricacao = objeto.dataFabricacao;
        this.dataValidade = objeto.dataValidade;
        this.cidadeFabricacao = objeto.cidadeFabricacao;
        this.empresaFornecedora = objeto.empresaFornecedora;
    }

    public Produto(Integer id, String nome, Float preco, String lote, LocalDate dataFabricacao, LocalDate dataValidade, String cidadeFabricacao, String empresaFornecedora) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.lote = lote;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.cidadeFabricacao = cidadeFabricacao;
        this.empresaFornecedora = empresaFornecedora;
    }

    public Integer getId() {
        return id;
    }

    public String getNome(){ return nome; }

    @Override
    public List<String> obterDadosProduto() {
        return Arrays.asList(this.nome, this.preco.toString(), this.dataValidade.toString());
    }

    @Override
    public Float obterCapital(Funcionario funcionario) {
        return Estoque.obterQuantidade(this)*this.preco;
    }
}
