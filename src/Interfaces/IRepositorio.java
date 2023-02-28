package TrabalhoCadastraFilme.src.Interfaces;

import java.util.ArrayList;

public interface IRepositorio<T> {

    public ArrayList<T> Lista();

    public T RetornaPorId(int id);

    public void Insere(T entidade);

    public void Atualiza(int id, T entidade);

    public int ProximoId();

}
