# Sistema Bancário

Este projeto simula um sistema bancário simples em Java, com funcionalidades como cadastro de clientes, contas bancárias e operações financeiras (saque, depósito, transferência).

## Funcionalidades
- **Gerenciamento de Cliente e Contas**: Criação e remoção de clientes e contas.
- **Operações bancárias**: Depósito, saque e transferência entre contas.
- **Cálculo de rendimentos**: Aplicado às contas poupança com base em taxas de juros.

## Conceitos Usados
1. **Encapsulamento**: 
   - Todos os atributos das classes (ex.: saldo, número da conta) são privados e manipulados por métodos `get` e `set` para garantir segurança e integridade.
   - Exemplo:
   ```java
   public void setSaldo(double saldo) {
       if (saldo >= 0) {
           this.saldo = saldo;
       } else {
           System.out.println("Erro: Saldo inválido.");
       }
   }
   ```

2. **Construtores**:
   - Utilizados para inicializar objetos com valores válidos no momento de sua criação.
   - Exemplo na classe `Cliente`:
   ```java
   public Cliente(String nome, String cpf, String endereco) {
       this.nome = nome;
       this.cpf = cpf;
       this.endereco = endereco;
   }
   ```

3. **Interface `Transacoes`**: 
   - Padroniza as operações básicas (saque e depósito) para diferentes tipos de contas (corrente e poupança).
   - Exemplo:
   ```java
   public interface Transacoes {
       void sacar(double valor);
       void depositar(double valor);
   }
   ```
