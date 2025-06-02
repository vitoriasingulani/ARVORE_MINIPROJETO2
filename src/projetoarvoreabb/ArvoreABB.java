package projetoarvoreabb;

public class ArvoreABB {
    public No raiz;

    public No inserir(No raiz, Aluno a) {
        if (raiz == null) return new No(a);
        if (a.rgm < raiz.dado.rgm) raiz.esquerda = inserir(raiz.esquerda, a);
        else if (a.rgm > raiz.dado.rgm) raiz.direita = inserir(raiz.direita, a);
        return raiz;
    }

    public No buscar(No raiz, int rgm) {
        if (raiz == null || raiz.dado.rgm == rgm) return raiz;
        if (rgm < raiz.dado.rgm) return buscar(raiz.esquerda, rgm);
        return buscar(raiz.direita, rgm);
    }

    public No remover(No raiz, int rgm) {
        if (raiz == null) return null;
        if (rgm < raiz.dado.rgm) raiz.esquerda = remover(raiz.esquerda, rgm);
        else if (rgm > raiz.dado.rgm) raiz.direita = remover(raiz.direita, rgm);
        else {
            if (raiz.esquerda == null) return raiz.direita;
            else if (raiz.direita == null) return raiz.esquerda;
            No sucessor = encontrarMinimo(raiz.direita);
            raiz.dado = sucessor.dado;
            raiz.direita = remover(raiz.direita, sucessor.dado.rgm);
        }
        return raiz;
    }

    private No encontrarMinimo(No raiz) {
        while (raiz.esquerda != null) raiz = raiz.esquerda;
        return raiz;
    }

    public No esvaziar(No raiz) {
        if (raiz == null) return null;
        raiz.esquerda = esvaziar(raiz.esquerda);
        raiz.direita = esvaziar(raiz.direita);
        System.out.println("Removido: " + raiz.dado);
        return null;
    }

    public void preOrdem(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.dado);
            preOrdem(raiz.esquerda);
            preOrdem(raiz.direita);
        }
    }

    public void inOrdem(No raiz) {
        if (raiz != null) {
            inOrdem(raiz.esquerda);
            System.out.println(raiz.dado);
            inOrdem(raiz.direita);
        }
    }

    public void posOrdem(No raiz) {
        if (raiz != null) {
            posOrdem(raiz.esquerda);
            posOrdem(raiz.direita);
            System.out.println(raiz.dado);

        }
    }

    public void exibirGraficamente(No raiz, int nivel) {
        if (raiz == null) return;

        exibirGraficamente(raiz.direita, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); // Espaços para o recuo
        }
        System.out.println(raiz.dado);

        exibirGraficamente(raiz.esquerda, nivel + 1);
    }


}
