public class ListaDuplamenteEncadeada {
    No primeiroNo;
    No ultimoNo;

    public static void main(String[] args) {
        System.out.println("Olá, mundo!");
        No noA = new No("B");
        No noB = new No("C");
        No noX = new No("X");
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.inserirEmSequencia(noA);
        System.out.println("Tamanho após 1 inserção: " + lista.tamanho());
        lista.inserirEmSequencia(noB);
        System.out.println("Tamanho após 2 inserções: " + lista.tamanho());
        lista.inserirEmSequencia(noX);
        System.out.println("Tamanho após 3 inserções: " + lista.tamanho());
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

    public boolean soTemUmNo() {
        return this.primeiroNo == this.ultimoNo;
    }

    public void inserirDepois(No noDaVez, No proximoNo) {
        No p = noDaVez;
        No noOrfao = p.getProximoNo();
        No X = proximoNo;
        proximoNo.setDado("X");
        proximoNo.setNoAnterior(noDaVez);
        proximoNo.setProximoNo(noOrfao);
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
}
