package sevices;

public abstract class Conta implements Transacoes{

    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, Cliente cliente) {
        setNumero(numero);
        setCliente(cliente);
        setSaldo(0);
    }

    @Override
    public abstract void sacar(double valor);

    @Override
    public abstract void depositar(double valor);

    public abstract void transferir(Conta contaDestino, double valor);

    public String getNumero() {
        return numero;
    }

    public void exibirInformacoes() {
        System.out.println("==== Informações da Conta ====");
        System.out.println("Número da conta: " + getNumero());
        System.out.println("Nome do titular: " + getCliente().getNome());
        System.out.println("Saldo: R$" + getSaldo());
    }

    public void setNumero(String numero) {
        if(numero != null && !numero.trim().isEmpty()){
            this.numero = numero;
        }else{
            System.out.println("Erro: O número da conta não pode ser nulo ou vazio.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if(cliente != null){
            this.cliente = cliente;
        }else{
            System.out.println("Erro: O cliente não pode ser nulo.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo >= 0){
            this.saldo = saldo;
        }else{
            System.out.println("Erro: O saldo da conta não pode ser negativo.");
        }
    }
}
