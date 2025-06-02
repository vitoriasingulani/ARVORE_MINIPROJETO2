package projetoarvoreabb;

public class No {
    public Aluno dado;
    public No esquerda, direita;

    public No(Aluno dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}
