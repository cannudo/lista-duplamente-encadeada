public class ListaDuplamenteEncadeada {
    No cabeca;
    No cauda;

    public static void main(String[] args) {
        System.out.println("Olá, mundo!");
        No noA = new No("A");
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.inserirEmSequencia(noA);
    }

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
    }

    public boolean estaVazia() {
        return (this.cabeca == null) && (this.cauda == null);
    }

    public boolean temNoCabeca() {
        return this.cabeca != null;
    }

    public boolean temNoCauda() {
        return this.cauda != null;
    }

    public void inserirDepois(No noDaVez, No novoNo) {
        if(this.estaVazia()) {
            throw new RuntimeException("A lista está vazia.");
        }
        if(!esteNoExisteNaLista(noDaVez)) {
            throw new RuntimeException("O nó de referência não existe na lista.");
        }
        if(this.soTemUmNo()) {
            this.inserirEmSequencia(novoNo);
            return;
        }
        No noOrfao = noDaVez.getProximoNo();
        noDaVez.setProximoNo(novoNo);
        noOrfao.setNoAnterior(novoNo);
        novoNo.setNoAnterior(noDaVez);
        novoNo.setProximoNo(noOrfao);
    }

    public boolean soTemUmNo() {
        return this.cabeca == this.cauda;
    }

    public void setCabeca(No cabeca) {
        this.cabeca = cabeca;
    }

    public void inserirEmSequencia(No novoNo) {
        // 1 - A lista está vazia
        if(this.estaVazia()) {
            this.setCabeca(novoNo);
            this.setCauda(novoNo);
        } else {
            // 2 - Tem um nó na lista, mas só ele
            if(this.soTemUmNo()) {
                this.setCauda(novoNo);
                this.getCabeca().setProximoNo(novoNo);
                this.getCauda().setNoAnterior(this.getCabeca());
            } else {
                // 3 - o nó é só mais um
                novoNo.setNoAnterior(this.getCauda());
                this.getCauda().setProximoNo(novoNo);
                this.setCauda(novoNo);
            }
        }
    }

    public No getCauda() {
        return cauda;
    }

    public void setCauda(No cauda) {
        this.cauda = cauda;
    }

    public No getCabeca() {
        return this.cabeca;
    }

    public int tamanho() {
        if(this.estaVazia()) {
            return 0;
        }
        if(this.soTemUmNo()) {
            return 1;
        }
        int contador = 0;
        No ultimoNo = this.cauda;
        No oNoDaVez = this.cabeca;
        while(oNoDaVez != null) {
            contador++;
            oNoDaVez = oNoDaVez.getProximoNo();
        }
        return contador;
    }

    public boolean esteNoExisteNaLista(No noBuscado) {
        if(this.estaVazia()) {
            return false;
        }
        No oNoDaVez = this.getCabeca();
        while(oNoDaVez != null) {
            if(oNoDaVez == noBuscado) return true;
            oNoDaVez = oNoDaVez.getProximoNo();
        }
        return false;
    }
}
