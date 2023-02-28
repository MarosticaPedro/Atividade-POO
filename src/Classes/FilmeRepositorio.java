package TrabalhoCadastraFilme.src.Classes;

import TrabalhoCadastraFilme.src.Interfaces.IRepositorio;

import java.util.ArrayList;

public class FilmeRepositorio implements IRepositorio<Filme> {

    private final ArrayList<Filme> listaFilme = new ArrayList<Filme>();
    
    public ArrayList<Filme> Lista() {

        return listaFilme;
    }
    
    //retorna o Id
    public Filme RetornaPorId(int id) {

        return listaFilme.get(id);
    }

    //Insere o filme
    public void Insere(Filme entidade) {
        listaFilme.add(entidade);
    }

    //Atualiza o filme
    public void Atualiza(int id, Filme entidade) {
        listaFilme.remove(id);
        listaFilme.add(id, entidade);

    }
    // Seleciona o proximo id
    public int ProximoId() {

        return listaFilme.size();
    }

    public String toString(int id) {
        return listaFilme.get(id).toString();
   }
}