import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    private No raiz;

    //Contrutor
    public Arvore(){
        this.raiz = null;
    }


    //Encapsulamento
    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(int valNo) {
        this.raiz = setNovoNo(this.raiz, valNo);
    }

    public No setNovoNo(No no, int valor){
        if(no == null) {
            return new No(valor);
        }
        else if(valor < no.getValorNo()) {
            no.setNoEsquerdo(setNovoNo(no.getNoEsquerdo(), valor));

        }
        else if(valor > no.getValorNo()) {
            no.setNoDireito(setNovoNo(no.getNoDireito(), valor));

        }
        return no;
    }

    //Envia os dados para a remoção do Nó
    public void remocao(int valorNo){
        this.raiz = removeNo(this.raiz, valorNo);
    }

    //remover No
    public No removeNo(No no, int val){
        if (no == null) {
            return no;
        }

        if (val < no.getValorNo()) {
            no.setNoEsquerdo(removeNo(no.getNoEsquerdo(), val));
        }
        else if (val > no.getValorNo()) {
            no.setNoDireito(removeNo(no.getNoDireito(), val));
        }
        else {

            if (no.getNoEsquerdo() == null) {
                No temp = no.getNoDireito();
                no = null;
                return temp;

            } else if (no.getNoDireito() == null) {
                No temp = no.getNoEsquerdo();
                no = null;
                return temp;
            }
            No temp = minimoVal(no.getNoDireito());

            no.setValorNo(temp.getValorNo());

            no.setNoDireito(removeNo(no.getNoDireito(), temp.getValorNo()));
        }
        return no;
    }

    //Busca o Minimo valor
    public No minimoVal(No no) {
        No noAtual = no;
        while(noAtual.getNoEsquerdo() != null) {
            noAtual = noAtual.getNoEsquerdo();
        }
        return noAtual;
    }

    //Realiza a impressão PreOrdem
    public void imprimirPreOrdem(No no) {
        if (no != null) {
            System.out.printf(no.getValorNo() + ", ");
            imprimirPreOrdem(no.getNoEsquerdo());
            imprimirPreOrdem(no.getNoDireito());
        }
    }

    //Realiza a impressão InOrdem
    public void imprimirInOrdem(No no) {
        if (no != null) {
            imprimirInOrdem(no.getNoEsquerdo());
            System.out.printf(no.getValorNo() + ", ");
            imprimirInOrdem(no.getNoDireito());
        }
    }

    //Realiza a impressão pos Ordem
    public void imprimirPosOrdem(No no) {
        if (no != null) {
            imprimirPosOrdem(no.getNoEsquerdo());
            imprimirPosOrdem(no.getNoDireito());
            System.out.printf(no.getValorNo() + ", ");
        }
    }

    //Realiza a impressão em Nível
    public void imprimirNivel(No raiz) {
        if (raiz == null) {
            return;
        }
        Queue<No> nos = new LinkedList<>();
        nos.add(raiz);

        while (!nos.isEmpty()) {
            No no = nos.poll();
            System.out.printf(no.getValorNo() + ", ");

            if (no.getNoEsquerdo() != null) {
                nos.add(no.getNoEsquerdo());
            }

            if (no.getNoDireito() != null) {
                nos.add(no.getNoDireito());
            }
        }
    }


}


