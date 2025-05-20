# Sistema Bancário

Este projeto demonstra um sistema bancário simples utilizando conceitos fundamentais da programação orientada a objetos, como encapsulamento, métodos `get` e `set`, construtores e a utilização de interfaces.

---

## Estrutura do Sistema

O sistema é composto pelas seguintes classes principais:
- **Banco**: Gerencia clientes e contas.
- **Cliente**: Representa os dados de um cliente.
- **Conta** (classe abstrata): Base para os tipos de conta.
   - **ContaCorrente**: Possui um limite especial.
   - **ContaPoupanca**: Aplica rendimento sobre o saldo.
- **Transacoes** (interface): Padroniza operações financeiras básicas (saque e depósito).

---

## Como os Métodos `get` e `set` Foram Usados?

Os métodos `get` e `set` garantem o **encapsulamento** dos atributos, permitindo acessá-los e modificá-los de forma controlada. Isso proporciona segurança e evita alterações indevidas no estado do sistema.

- **Exemplo na classe `Conta`**:
   - O atributo privado `saldo` só pode ser acessado ou modificado via os métodos:
     ```java
     public double getSaldo() {
         return saldo;
     }
     
     public void setSaldo(double saldo) {
         if (saldo >= 0) { // Validação para evitar saldo negativo
             this.saldo = saldo;
         } else {
             System.out.println("Erro: O saldo não pode ser negativo.");
         }
     }
     ```

Outros atributos como `numero` e `cliente` também foram encapsulados por métodos `get` e `set` para garantir consistência.

---

## Construtores no Sistema

Os **construtores** são usados para inicializar as classes no momento de sua criação. Eles garantem que os objetos comecem com valores válidos.

- **Exemplo: Construtor da Classe `ContaPoupanca`**:
  ```java
  public ContaPoupanca(String numero, Cliente cliente, double taxaJuros) {
      super(numero, cliente); // Configura os atributos herdados
      setTaxaJuros(taxaJuros); // Validação para o atributo específico
  }
  ```
  Neste exemplo:
   - O construtor da classe-pai (`Conta`) é chamado usando `super`.
   - A taxa de juros é configurada e validada logo na criação.

- **Principais Construtores do Sistema**:
   1. **`Cliente`**: Recebe valores como `nome`, `cpf` e `endereço`.
   2. **`ContaCorrente` e `ContaPoupanca`**: Recebem valores específicos como o limite especial ou taxa de juros ao serem instanciadas.

---

## Interface `Transacoes`

A interface **`Transacoes`** padroniza os **métodos de saque e depósito** para todas as contas do banco. Isso significa que qualquer classe que implemente essa interface deve obrigatoriamente fornecer esses métodos.

- **Definição da Interface**:
  ```java
  public interface Transacoes {
      void sacar(double valor);
      void depositar(double valor);
  }
  ```
- **Implementação em `ContaPoupanca`**:
  ```java
  @Override
  public void sacar(double valor) {
      if (valor > 0 && valor <= getSaldo()) {
          setSaldo(getSaldo() - valor);
          System.out.println("Saque realizado com sucesso!");
      } else {
          System.out.println("Erro: Saldo insuficiente ou valor inválido.");
      }
  }
  
  @Override
  public void depositar(double valor) {
      if (valor > 0) {
          setSaldo(getSaldo() + valor);
          System.out.println("Depósito realizado com sucesso!");
      } else {
          System.out.println("Erro: O valor do depósito deve ser positivo.");
      }
  }
  ```

A interface permite adicionar novos tipos de contas futuramente sem alterar o funcionamento do sistema.

---

## Explicação dos Principais Setters

Os métodos `set` desempenham um papel importante ao validar e configurar atributos no sistema. Abaixo estão os principais setters:

1. **`setSaldo(double saldo)` (Classe `Conta`)**:
   - Valida se o saldo é maior ou igual a zero antes de aplicar a alteração:
     ```java
     public void setSaldo(double saldo) {
         if (saldo >= 0) {
             this.saldo = saldo;
         } else {
             System.out.println("Erro: O saldo não pode ser negativo.");
         }
     }
     ```

2. **`setTaxaJuros(double taxaJuros)` (Classe `ContaPoupanca`)**:
   - Garante que a taxa de juros seja positiva:
     ```java
     public void setTaxaJuros(double taxaJuros) {
         if (taxaJuros > 0) {
             this.taxaJuros = taxaJuros;
         } else {
             System.out.println("Erro: A taxa de juros deve ser positiva.");
         }
     }
     ```

3. **`setLimiteEspecial(double limiteEspecial)` (Classe `ContaCorrente`)**:
   - Valida que o limite especial seja positivo:
     ```java
     public void setLimiteEspecial(double limiteEspecial) {
         if (limiteEspecial > 0) {
             this.limiteEspecial = limiteEspecial;
         } else {
             System.out.println("Erro: O limite especial deve ser positivo.");
         }
     }
     ```

4. **`setCpf(String cpf)` (Classe `Cliente`)**:
   - Valida se o CPF segue o padrão de 11 dígitos numéricos:
     ```java
     public void setCpf(String cpf) {
         if (cpf != null && cpf.matches("\\d{11}")) {
             this.cpf = cpf;
         } else {
             System.out.println("Erro: CPF inválido.");
         }
     }
     ```
5. **`setNome(String nome)` (Classe `Cliente` e `Banco`)**:
   - Valida se o nome é nulo ou vazio antes de definir:
     ```java
     public void setNome(String nome) {
         if (nome != null && !nome.trim().isEmpty()) {
             this.nome = nome;
         } else {
             System.out.println("Erro: O nome não pode ser nulo ou vazio.");
         }
     }
     ```
   Este método é utilizado para garantir que tanto o nome de clientes quanto do banco sejam sempre válidos.


---

## 🌟 Exemplo de Uso
No programa principal (`Main.java`), é possível simular as operações do banco:
1. **Criar um cliente e uma conta corrent**.
   ```java
   Cliente cliente1 = new Cliente("João Silva", "12345678901", "Rua X");
   ContaCorrente contaCorrente = new ContaCorrente("001", cliente1, 500.0);
   ```
2. **Realizar um depósito e um saque**:
   ```java
   contaCorrente.depositar(1000.0);
   contaCorrente.sacar(700.0);
   ```
3. **Transferir entre contas**:
   ```java
   ContaPoupanca contaPoupanca = new ContaPoupanca("002", cliente2, 2.0);
   contaCorrente.transferir(contaPoupanca, 200.0);
   ```
