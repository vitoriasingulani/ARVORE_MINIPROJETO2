package projetoarvoreabb;

public class Aluno {
    public int rgm;
    public String nome;

    public Aluno(int rgm, String nome) {
        this.rgm = rgm;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return rgm + " - " + nome;
    }
}
