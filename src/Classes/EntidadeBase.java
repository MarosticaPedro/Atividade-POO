package TrabalhoCadastraFilme.src.Classes;

public abstract class EntidadeBase {
    protected int Id;

    public EntidadeBase(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    protected void setId(int id) {
        Id = id;
    }

}
