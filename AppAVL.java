package T3_classe_AVL_completa;

public class AppAVL {
    public static void main(String[] args) {
        //50, 30, 70, 10, 40, 35
        ArvoreAVL arvore = new ArvoreAVL();

        //parte de adicionar chaves na arvore
        arvore.adicionar(50);
        arvore.adicionar(40);
        arvore.adicionar(30);

        //imprime a arvore
        arvore.imprimirArvore();

        arvore.percorrerEmPreOrdem();
    }
}
