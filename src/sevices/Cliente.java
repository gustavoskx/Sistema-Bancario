package sevices;

import java.util.ArrayList;
import java.util.List;

public class Cliente{
    private String nome;
    private String cpf;
    private String endereco;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, String endereco) {
        setNome(nome);
        setCpf(cpf);
        setEndereco(endereco);
        setContas(new ArrayList<>());
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        if (contas != null) {
            this.contas = contas;
        } else {
            System.out.println("Erro: A lista de contas não pode ser nula.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido. O CPF deve conter exatamente 11 dígitos numéricos.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Erro: O nome do cliente não pode ser nulo ou vazio.");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco != null && !endereco.trim().isEmpty()) {
            this.endereco = endereco;
        } else {
            System.out.println("Erro: O endereço do cliente não pode ser nulo ou vazio.");
        }
    }
}
