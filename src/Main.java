import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arvore arvore = new Arvore();
        Random rand = new Random();

        System.out.println("\n\n================= Inserção de Dados ================");
        int[] array = new int[20];
        for (int i=0; i < 20; i++){
            int valorInsercao = rand.nextInt(101);
            arvore.setRaiz(valorInsercao);
            array[i] = valorInsercao;
        }
        System.out.println("----> Dados Inseridos na Arvore\n\n");
        arvore.imprimirPreOrdem(arvore.getRaiz());
        System.out.println("\n====================================================\n\n");


        int op = 0;

        do{
            op = menu();
            if(op == 1){
                System.out.println("\n\n================= Exlusão de 5 Nós =================");
                for(int i=0; i < 5; i++){
                    System.out.print("----> Valores dos Nós: ");
                    arvore.imprimirPreOrdem(arvore.getRaiz());
                    System.out.print("\nDigite o valor a ser exluído: ");
                    int remocao = scan.nextInt();
                    arvore.remocao(remocao);
                    System.out.println("\n----> Nó Removido!\n");
                }
                System.out.println("====================================================\n\n");
                op = solicitacao();
            }
            else if(op == 2){
                System.out.println("\n\n================ Impressão PreOrdem ================");
                arvore.imprimirPreOrdem(arvore.getRaiz());
                System.out.println("\n====================================================\n\n");
                op = solicitacao();
            }
            else if(op == 3){
                System.out.println("\n\n================= Impressão InOrdem ================");
                arvore.imprimirInOrdem(arvore.getRaiz());
                System.out.println("\n====================================================\n\n");
                op = solicitacao();
            }
            else if(op == 4){
                System.out.println("\n\n================ Impressão PreOrdem ================");
                arvore.imprimirPosOrdem(arvore.getRaiz());
                System.out.println("\n====================================================\n\n");
                op = solicitacao();
            }
            else if(op == 5){
                System.out.println("\n\n================ Impressão em Nível ================");
                arvore.imprimirNivel(arvore.getRaiz());
                System.out.println("\n====================================================\n\n");
                op = solicitacao();
            }
            else if(op == 0){
                continue;
            }
            else{
                System.out.println("----> Comando não entendido!");
                op = solicitacao();

            }
        }while(op != 0);
        System.out.println("----> Sessão Finalizada, Tenha um bom dia!");
    }

    public static int menu(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n======================= Menu =======================");
        System.out.println("1- Excluir um Nó da Arvore");
        System.out.println("2- Imprimir PreOrdem na Arvore");
        System.out.println("3- Imprimir InOrdem na Arvore");
        System.out.println("4- Imprimir PosOrdem na Arvore");
        System.out.println("5- Imprimir em Nível na Arvore");
        System.out.println("0- Sair!");
        System.out.println("----------------------------------------------------");
        System.out.printf("----> Digite a Opção Desejada: ");
        int op = scan.nextInt();
        System.out.println("====================================================\n\n");

        return op;
    }

    public static int solicitacao(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1- Sim");
        System.out.println("0- Não");
        System.out.printf("----> Digite a Opção Desejada: ");
        int op = scan.nextInt();

        return op;
    }
}