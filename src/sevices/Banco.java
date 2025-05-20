package sevices;

import java.util.ArrayList;
import java.util.List;

public class Banco{
    private String nome;
    private String codigoBanco;
    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco(String nome, String codigoBanco) {
        setNome(nome);
        setCodigoBanco(codigoBanco);
        setClientes(new ArrayList<>());
        setContas(new ArrayList<>());
    }

    public void adicionarConta(Conta conta) {
        if (!this.clientes.contains(conta.getCliente())) {
            this.clientes.add(conta.getCliente());
            System.out.println("Cliente " + conta.getCliente().getNome() + " adicionado à lista de clientes.");
        }

        this.contas.add(conta);
        conta.getCliente().getContas().add(conta);
        System.out.println("Conta " + conta.getNumero() + " criada com sucesso para o cliente " + conta.getCliente().getNome());
    }

    public void removerConta(Conta conta) {
        if (!contas.contains(conta)) {
            System.out.println("Erro: A conta não está registrada no banco.");
            return;
        }

        contas.remove(conta);

        Cliente cliente = conta.getCliente();
        if (cliente != null) {
            cliente.getContas().remove(conta);

            if (cliente.getContas().isEmpty()) {
                clientes.remove(cliente);
                System.out.println("Cliente " + cliente.getNome() + " removido, pois não possui mais contas.");
            }
        }

        System.out.println("Conta " + conta.getNumero() + " removida com sucesso.");
    }

    public Cliente encontrarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Erro: Cliente não encontrado.");
        return null;
    }

    public Conta encontrarContaPorNumero(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        System.out.println("Erro: Conta não encontrada.");
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: O nome do banco não pode ser vazio ou nulo.");
        } else {
            this.nome = nome;
        }
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        if (codigoBanco == null || codigoBanco.trim().isEmpty()) {
            System.out.println("Erro: O código do banco não pode ser vazio ou nulo.");
        } else if (!codigoBanco.matches("\\d+")) {
            System.out.println("Erro: O código do banco deve conter apenas números.");
        } else {
            this.codigoBanco = codigoBanco;
        }
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        if (contas == null) {
            System.out.println("Erro: A lista de contas não pode ser nula.");
        } else {
            this.contas = contas;
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        if (clientes == null) {
            System.out.println("Erro: A lista de clientes não pode ser nula.");
        } else {
            this.clientes = clientes;
        }
    }
}