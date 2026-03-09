public class ListaDuplamenteEncadeada {
    No primeiroNo;
    No ultimoNo;

    public static void main(String[] args) {
        System.out.println("Olá, mundo!");
        No noA = new No("A");
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.inserirEmSequencia(noA);
    }

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public boolean estaVazia() {
        return (this.primeiroNo == null) && (this.ultimoNo == null);
    }

    public boolean temPrimeiroNo() {
        return this.primeiroNo != null;
    }

    public boolean temUltimoNo() {
        return this.ultimoNo != null;
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
        return this.primeiroNo == this.ultimoNo;
    }

    public void setPrimeiroNo(No primeiroNo) {
        this.primeiroNo = primeiroNo;
    }

    public void inserirEmSequencia(No novoNo) {
        // 1 - A lista está vazia
        if(this.estaVazia()) {
            this.setPrimeiroNo(novoNo);
            this.setUltimoNo(novoNo);
        } else {
            // 2 - Tem um nó na lista, mas só ele
            if(this.soTemUmNo()) {
                this.setUltimoNo(novoNo);
                this.getPrimeiroNo().setProximoNo(novoNo);
                this.getUltimoNo().setNoAnterior(this.getPrimeiroNo());
            } else {
                // 3 - o nó é só mais um
                novoNo.setNoAnterior(this.getUltimoNo());
                this.getUltimoNo().setProximoNo(novoNo);
                this.setUltimoNo(novoNo);
            }
        }
    }

    public No getUltimoNo() {
        return ultimoNo;
    }

    public void setUltimoNo(No ultimoNo) {
        this.ultimoNo = ultimoNo;
    }

    public No getPrimeiroNo() {
        return this.primeiroNo;
    }

    public int tamanho() {
        if(this.estaVazia()) {
            return 0;
        }
        if(this.soTemUmNo()) {
            return 1;
        }
        int contador = 0;
        No ultimoNo = this.ultimoNo;
        No oNoDaVez = this.primeiroNo;
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
        No oNoDaVez = this.getPrimeiroNo();
        while(oNoDaVez != null) {
            if(oNoDaVez == noBuscado) return true;
            oNoDaVez = oNoDaVez.getProximoNo();
        }
        return false;
    }
}
