package sevices;

public class Main {
    public static void main(String[] args) {

        Banco meuBanco = new Banco("Banco Exemplo", "123");

        Cliente cliente1 = new Cliente("João Silva", "12345678901", "Rua A, 10");
        Cliente cliente2 = new Cliente("Maria Oliveira", "98765432100", "Rua B, 20");

        ContaCorrente contaCorrente = new ContaCorrente("001", cliente1, 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("002", cliente2, 2.0);

        System.out.println("=== Cadastro de contas no banco ===");
        meuBanco.adicionarConta(contaCorrente);
        meuBanco.adicionarConta(contaPoupanca);

        System.out.println("\n=== Depósitos nas contas ===");
        contaCorrente.depositar(1000.0);
        contaPoupanca.depositar(500.0);

        contaCorrente.exibirInformacoes();
        contaPoupanca.exibirInformacoes();

        System.out.println("\n=== Saque Conta Corrente ===");
        contaCorrente.sacar(1200.0); // Saque com uso do limite especial
        contaCorrente.exibirInformacoes();

        System.out.println("\n=== Saque Conta Poupança ===");
        contaPoupanca.sacar(200.0);
        contaPoupanca.exibirInformacoes();

        System.out.println("\n=== Transferência entre contas ===");
        contaPoupanca.transferir(contaCorrente, 100.0);
        contaCorrente.exibirInformacoes();
        contaPoupanca.exibirInformacoes();

        System.out.println("\n=== Rendimentos Conta Poupança ===");
        contaPoupanca.calcularRendimentos();
    }
}