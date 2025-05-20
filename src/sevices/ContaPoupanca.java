package sevices;

public final class ContaPoupanca extends Conta{
    private double taxaJuros;

    public ContaPoupanca(String numero, Cliente cliente, double taxaJuros) {
        super(numero, cliente);
        setTaxaJuros(taxaJuros);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= getSaldo()) {
                setSaldo(getSaldo() - valor);
                System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("O valor do saque deve ser positivo.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da transferência deve ser positivo.");
            return;
        }
        if (this.getSaldo() >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso de Conta " +
                    this.getNumero() + " para Conta " + contaDestino.getNumero());
        } else {
            System.out.println("Erro: Saldo insuficiente para realizar a transferência.");
        }
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Taxa de juros: " + taxaJuros + "%");
    }

    public void calcularRendimentos() {
        double rendimentos = this.getSaldo() * (taxaJuros / 100);
        System.out.println("[Saldo atual: R$" + this.getSaldo()+"]");
        System.out.println("[Rendimentos de R$" + rendimentos + " calculados com sucesso!]");
        System.out.println("[Saldo atual com os rendimentos: R$" + this.getSaldo()+"]");
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        if (taxaJuros > 0) {
            this.taxaJuros = taxaJuros;
        }else{
            System.out.println("Taxa de juros deve ser positiva.");
        }
    }
}
