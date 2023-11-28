package T3_classe_AVL_completa;

public class ArvoreAVL {
    private NodoAVL raiz;
    private int tamanho;
    private String caminhoPreOrdem;
    private String caminhoPosOrdem;
    private String caminhoLargura;
    public NodoAVL getRaiz(ArvoreAVL arvore) {
        return arvore.raiz;
    }
    public int getTamanho(ArvoreAVL arvore) {
        return arvore.tamanho;
    }
    public String getCaminhoPreOrdem(ArvoreAVL arvore) {
        return caminhoPreOrdem;
    }
    public String getCaminhoPosOrdem(ArvoreAVL arvore) {
        return caminhoPosOrdem;
    }
    public String getCaminhoLargura(ArvoreAVL arvore) {
        return caminhoLargura;
    }

    public void adicionar(int chave) {
        raiz = adicionar(chave, raiz);
        tamanho++;
    }
    //implementar remover
    public void remover(int chave) {
        if (raiz.chave == chave) {
            raiz = null;
        }
        else if (chave < raiz.chave) {
            if (raiz.esquerda.chave == chave) {
                raiz.esquerda = null;
            }
        }
    }
    //implementar existe
    public boolean existe(int chave) {
        return true;
    }
    private int maximo(int a, int b) {
        if(a>b) return a;
        else return b;
    }
    private int obterAltura(NodoAVL n) {
        if(n==null) return -1;
        else return n.altura;
    }
    private int calcularFatorBalanceamento(NodoAVL n) {
        if(n==null) return 0;
        else return obterAltura(n.esquerda) - obterAltura(n.direita);
    }

    private NodoAVL adicionar(int chave, NodoAVL raiz) {
        if(raiz==null) {
            raiz = new NodoAVL(chave);
        }
        else if (chave < raiz.chave) {
            raiz.esquerda = adicionar(chave, raiz.esquerda);
        }
        else if (chave > raiz.chave) {
            raiz.direita = adicionar(chave, raiz.direita);
        }

        raiz = balancear(raiz, chave);
        return raiz;
    }
    private NodoAVL balancear(NodoAVL nodo, int chave) {
        int fatorBalanceamento = calcularFatorBalanceamento(nodo);

        //atualiza a altura somando 1 recursivamente ate a raiz, folha altura = 0
        nodo.altura = maximo(obterAltura(nodo.esquerda), obterAltura(nodo.direita)) + 1;

        if (fatorBalanceamento > 1 && chave < nodo.esquerda.chave) {
            System.out.println("Rotacao simples a direita");
            return rotacaoSimplesDireita(nodo);
        }

        if (fatorBalanceamento < -1 && chave > nodo.direita.chave) {
            System.out.println("Rotacao simples a esquera");
            return rotacaoSimplesEsquerda(nodo);
        }

        if (fatorBalanceamento > 1 && chave > nodo.esquerda.chave) {
            System.out.println("Rotacao Esquerda Direita");
            return rotacaoEsquerdaDireita(nodo);
        }

        if (fatorBalanceamento < -1 && chave < nodo.direita.chave) {
            System.out.println("Rotacao Direita Esquerda");
            return rotacaoDireitaEsquerda(nodo);
        }
        return nodo;
    }

    private NodoAVL rotacaoSimplesDireita(NodoAVL B) {
        NodoAVL A = B.esquerda;
        B.esquerda = A.direita;
        A.direita = B;
        B.altura = maximo(obterAltura(B.esquerda), obterAltura(B.direita)) + 1;
        A.altura = maximo(obterAltura(A.esquerda), obterAltura(A.direita)) + 1;
        return A;
    }

    private NodoAVL rotacaoSimplesEsquerda(NodoAVL B) {
        NodoAVL A = B.direita;
        B.direita = A.esquerda;
        A.esquerda = B.esquerda;
        B.altura = maximo(obterAltura(B.esquerda), obterAltura(B.direita)) + 1;
        A.altura = maximo(obterAltura(A.esquerda), obterAltura(A.direita)) + 1;
        return A;
    }
    private NodoAVL rotacaoEsquerdaDireita(NodoAVL n) {
        System.out.println("Rotacao a esquerda no nodo " + n.esquerda.chave);
        System.out.println("Rotacao a direita no nodo " + n.chave);
        n.esquerda = rotacaoSimplesEsquerda(n.direita);
        return  rotacaoSimplesDireita(n);
    }

    private NodoAVL rotacaoDireitaEsquerda(NodoAVL n) {
        System.out.println("Rotacao a direita no nodo " + n.direita.chave);
        System.out.println("Rotacao a esquerda no nodo " + n.chave);
        n.direita = rotacaoSimplesDireita(n.esquerda);
        return  rotacaoSimplesEsquerda(n);
    }

    public void imprimirArvore() {
        imprimirArvoreRecusivamente(this.raiz, 0);
    }
    private void imprimirArvoreRecusivamente(NodoAVL raiz, int nivel) {
        if (raiz == null) return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.chave + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }

    public void percorrerEmPreOrdem() {
        percorrerEmPreOrdemRecursivo(raiz);
        System.out.println();
    }
    private void percorrerEmPreOrdemRecursivo(NodoAVL n) {
        if(n == null) return;
        System.out.printf(" " + n.chave);
        percorrerEmPreOrdemRecursivo(n.esquerda);
        percorrerEmPreOrdemRecursivo(n.direita);
    }
}
