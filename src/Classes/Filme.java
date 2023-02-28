package TrabalhoCadastraFilme.src.Classes;

public class Filme extends EntidadeBase {

    // Atributos
    private String Genero;
    private String Titulo;
    private String Descricao;
    private int Ano;
    private int Duracao;

    //Métodos
    public Filme(int id) {
        super(id);
    }

    public Filme(int id, String titulo, int ano, String genero, String descricao, int duracao) {
        super(id);
        this.Ano = ano;
        this.Titulo = titulo;
        this.Genero = genero;
        this.Descricao = descricao;
        this.Duracao = duracao;
    }

    //Métodos de acesso
    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        Ano = ano;
    }
    

    public int getDuracao() {
        return Duracao;
    }

    public void setDuracao(int duracao) {
        Duracao = duracao;
    }

    // Métodos
    public String toString() {
        String retorno = "\n";
        retorno += "Id: " + this.Id + "\n";
        retorno += "Gênero: " + this.Genero + "\n";
        retorno += "Titulo: " + this.Titulo + "\n";
        retorno += "Descrição: " + this.Descricao + "\n";
        retorno += "Ano de Lançamento: " + this.Ano + "\n";
        retorno += "Duração: " + this.Duracao + " minutos\n ";

        return retorno;
    }

    public String retornaTitulo() {
        return this.Titulo;
    }

    public int retornaId() {
        return this.Id;
    }

}
