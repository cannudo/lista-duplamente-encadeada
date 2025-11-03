public class No {
    private No noAnterior;
    private String dado;
    private No proximoNo;

    public No() { /* Um nó vazio */
        this.noAnterior = null;
        this.dado = null;
        this.proximoNo = null;
    }

    public No(String dado) {
        this.noAnterior = null;
        this.dado = dado;
        this.proximoNo = null;
    }

    public No(No noAnterior, String dado, No proximoNo) {
        this.noAnterior = noAnterior;
        this.dado = dado;
        this.proximoNo = proximoNo;
    }
}