package sevices;

public final class ContaCorrente extends Conta{
    private double limiteEspecial;

    public ContaCorrente(String numero, Cliente cliente, double limiteEspecial) {
        super(numero, cliente);
        setLimiteEspecial(limiteEspecial);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= (getSaldo() + limiteEspecial)) {
                if (valor <= getSaldo()) {
                    setSaldo(getSaldo() - valor);
                } else {
                    double restante = valor - getSaldo();
                    setSaldo(0);
                    limiteEspecial -= restante;
                }
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente, mesmo considerando o limite especial.");
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
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Limite especial: R$" + getLimiteEspecial());
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da transferência deve ser positivo.");
            return;
        }
        if (this.getSaldo() + limiteEspecial >= valor) {
            if (valor <= getSaldo()) {
                setSaldo(getSaldo() - valor);
            } else {
                double restante = valor - getSaldo();
                setSaldo(0);
                limiteEspecial -= restante;
            }
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso para a conta " + contaDestino.getNumero());
        } else {
            System.out.println("Erro: Saldo insuficiente (considerando o limite especial) para realizar a transferência.");
        }
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        if (limiteEspecial > 0) {
            this.limiteEspecial = limiteEspecial;
        }else{
            System.out.println("Limite especial deve ser positivo.");
        }
    }
}