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

    public boolean temNoAnterior() {
        return this.noAnterior != null;
    }

    public boolean temProximoNo() {
        return this.proximoNo != null;
    }

    public No getNoAnterior() {
        return this.noAnterior;
    }

    public void setNoAnterior(No noAnterior) {
        this.noAnterior = noAnterior;
    }

    public String getDado() {
        return this.dado;
    }

    public void setDado(String dado) {
        this.dado = dado;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

}