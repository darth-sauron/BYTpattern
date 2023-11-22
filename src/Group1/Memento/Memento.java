package Group1.Memento;

public class Memento {
    private Block saved;

    public Memento(Block saved){
        this.saved = saved;
    }

    public Block getSaved(){
        return this.saved;
    }
}
