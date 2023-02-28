package TrabalhoCadastraFilme.src;

import TrabalhoCadastraFilme.src.Classes.EntidadeBase;
import TrabalhoCadastraFilme.src.Classes.Filme;
import TrabalhoCadastraFilme.src.Classes.FilmeRepositorio;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    // a lista abaixo serve para colocar os itens excluidos
    static ArrayList<Filme> listaExcluido = new ArrayList<>();

    // lista principal
    static FilmeRepositorio repositorio = new FilmeRepositorio();

    public static void main(String[] args) throws Exception {

        String opcaoUsuario = ObterOpcaoUsuario(); // Variável que guarda opção do usuário

        while (!opcaoUsuario.toUpperCase().equals("X")) {
            switch (opcaoUsuario) {
                case "1" -> ListarFilme();
                case "2" -> InserirFilme();
                case "3" -> AtualizarFilme();
                case "4" -> ExcluirFilme();
                case "5" -> VisualizarFilme();
                default -> System.exit(1);
            }

            opcaoUsuario = ObterOpcaoUsuario();
        }

        JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossos serviços.");

    }

    private static void ExcluirFilme() {
        // chamada da lista principal e o Id que quer excluir
        var lista = repositorio.Lista();
        if (lista.size() == 0) {
            // se não tiver nenhum elemento na lista ele retorna que não tem filme
            // cadastrado
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado");
        } else {
            // percorre a lista principal
            for (int i = 0; i < lista.size(); i++) {
                Filme ax = repositorio.RetornaPorId(i);

                int indiceFilme = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Filme: "));
                if (indiceFilme == ax.getId()) {
                    // caso encontre o id desejado ele adiciona numa lista separada e remove da
                    // lista principal
                    listaExcluido.add(ax);
                    repositorio.Lista().remove(ax);

                    JOptionPane.showMessageDialog(null, "Filme excluido");

                }
            }
        }
    }

    private static void VisualizarFilme() {
        // lista local
        var lista = repositorio.Lista();
        // Verifica se está vazia
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado");
        } else {

            int indiceFilme = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Filme: "));

            var eFilme = repositorio.toString(indiceFilme);

            JOptionPane.showMessageDialog(null, eFilme);
        }

    }

    private static void AtualizarFilme() {
        var lista = repositorio.Lista();
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado");
        } else {
            int indiceFilme = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Filme: "));

            String entradaGenero = JOptionPane.showInputDialog(null, "Digite um gênero");

            String entradaTitulo = JOptionPane.showInputDialog(null, "Digite um título");

            int entradaAno = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de lançamento"));

            String entradaDescricao = JOptionPane.showInputDialog(null, "Digite a sinopse do filme");

            int entradaDuracao = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Digite a duração do filme em minutos"));

            EntidadeBase novoFilme = new Filme(indiceFilme, entradaTitulo, entradaAno, entradaGenero, entradaDescricao,
                    entradaDuracao);

            repositorio.Atualiza(indiceFilme, (Filme) novoFilme);
        }
    }

    private static void ListarFilme() {
        JOptionPane.showMessageDialog(null, "Listar filme");
        // Lista local
        var lista = repositorio.Lista();
        // Verifica se está vazio
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado");

        }

        for (var Filme : lista) {

            JOptionPane.showMessageDialog(null, "{" + Filme.retornaId() + "}  " + Filme.retornaTitulo());

        }
    }

    private static void InserirFilme() {
        JOptionPane.showMessageDialog(null, "Inserir novo filme");

        int index = repositorio.ProximoId();

        String entradaGenero = JOptionPane.showInputDialog(null, "Digite um gênero");

        String entradaTitulo = JOptionPane.showInputDialog(null, "Digite um título");

        int entradaAno = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de lançamento"));

        String entradaDescricao = JOptionPane.showInputDialog(null, "Digite a sinopse do filme");

        int entradaDuracao = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Digite a duração do filme em minutos"));

        EntidadeBase novoFilme = new Filme(index, entradaTitulo, entradaAno, entradaGenero, entradaDescricao,
                entradaDuracao);

        repositorio.Insere(((Filme) novoFilme));
    }

    private static String ObterOpcaoUsuario() {

        JOptionPane.showMessageDialog(null, "Informe a opção desejada:");

        return JOptionPane.showInputDialog(null, "1- Listar filme\n" + "2- Inserir novo filme\n"
                + "3- Atualizar filme\n" + "4- Excluir filme\n" + "5- Visualizar filme\n" + "X- Sair").toUpperCase();
    }
}
