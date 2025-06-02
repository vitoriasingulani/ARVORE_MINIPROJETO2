package projetoarvoreabb;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreABB arvore = new ArvoreABB();

        // Ler dados do arquivo
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/projetoarvoreabb/dados.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                int rgm = Integer.parseInt(partes[0].trim());
                String nome = partes[1].trim();
                arvore.raiz = arvore.inserir(arvore.raiz, new Aluno(rgm, nome));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado ou erro na leitura.");
        }

        int opcao;
        do {
            System.out.println("\n---------------------------------");
            System.out.println("ALUNO: SEU NOME AQUI");
            System.out.println("DISCIPLINA: ESTRUTURA DE DADOS I");
            System.out.println("PROFESSOR: WALACE BONFIM");
            System.out.println("---------------------------------");
            System.out.println("1 - Inserir");
            System.out.println("2 - Remover");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Esvaziar árvore");
            System.out.println("5 - Exibir (1-Pré | 2-In | 3-Pós)");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o RGM: ");
                    int rgm = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Informe o nome: ");
                    String nome = sc.nextLine();
                    arvore.raiz = arvore.inserir(arvore.raiz, new Aluno(rgm, nome));
                    break;

                case 2:
                    System.out.print("Informe o RGM para remover: ");
                    rgm = sc.nextInt();
                    No encontrado = arvore.buscar(arvore.raiz, rgm);
                    if (encontrado != null) {
                        System.out.println("Removido: " + encontrado.dado);
                        arvore.raiz = arvore.remover(arvore.raiz, rgm);
                    } else {
                        System.out.println("RGM não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Informe o RGM para pesquisar: ");
                    rgm = sc.nextInt();
                    encontrado = arvore.buscar(arvore.raiz, rgm);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado.dado);
                    } else {
                        System.out.println("RGM não encontrado.");
                    }
                    break;

                case 4:
                    arvore.raiz = arvore.esvaziar(arvore.raiz);
                    System.out.println("Árvore esvaziada.");
                    break;

                case 5:
                    System.out.println("1 - Pré-Ordem");
                    System.out.println("2 - In-Ordem");
                    System.out.println("3 - Pós-Ordem");
                    System.out.println("4 - Visualizar estrutura da árvore");
                    System.out.print("Escolha: ");
                    int tipo = sc.nextInt();
                    if (tipo == 1) {
                        System.out.println("Pré-Ordem:");
                        arvore.preOrdem(arvore.raiz);
                    } else if (tipo == 2) {
                        System.out.println("In-Ordem:");
                        arvore.inOrdem(arvore.raiz);
                    } else if (tipo == 3) {
                        System.out.println("Pós-Ordem:");
                        arvore.posOrdem(arvore.raiz);
                    } else if (tipo == 4) {
                        System.out.println("Estrutura da árvore:");
                        arvore.exibirGraficamente(arvore.raiz, 0);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;


                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
        System.out.println("Árvore carregada a partir do arquivo:");
        arvore.exibirGraficamente(arvore.raiz, 0);
    }
}