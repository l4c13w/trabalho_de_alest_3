package T3_classe_AVL_completa;

public class AppAVL {
    public static void main(String[] args) {
        //arvore1
        ArvoreAVL arvore1 = new ArvoreAVL();
        arvore1.adicionar(50);
        arvore1.adicionar(40);
        arvore1.adicionar(30);

        //arvore2
        //ArvoreAVL arvore2 = new ArvoreAVL();
        //arvore2.adicionar(10);
        //arvore2.adicionar(20);
        //arvore2.adicionar(30);

        //arvore3
        //ArvoreAVL arvore3 = new ArvoreAVL();
        //arvore3.adicionar(50);
        //arvore3.adicionar(20);
        //arvore3.adicionar(80);
        //arvore3.adicionar(67);
        //arvore3.adicionar(91);
        //arvore3.adicionar(97);

        //arvore4
        //ArvoreAVL arvore4 = new ArvoreAVL();
        //arvore4.adicionar(50);
        //arvore4.adicionar(30);
        //.adicionar(70);
        //arvore4.adicionar(10);
        //arvore4.adicionar(40);
        //arvore4.adicionar(35);

        //imprime arvores
        arvore1.imprimirArvore();
        //arvore2.imprimirArvore();
        //arvore3.imprimirArvore();
        //arvore4.imprimirArvore();

        //arvore1.percorrerEmPreOrdem();
    }
}
