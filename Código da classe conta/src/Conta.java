/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Conta {

    // Definição dos atributo da classe
    private int id;
    private String nome;
    private float saldo;
    private float limite = 200; // Limite padrão de 200 reais para todos

    // Definição dos gets e sets dos atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        // Verifica se o valor repassado é maior que zero
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Não é possivel colocar um valor negativo.");
        }
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    // Metodo para realizar o saque
    public boolean sacar(float valor) {
        if (valor >= 0) { // Verifica número maior que zero 
            if (valor <= this.saldo + this.limite) { // Verifica se o valor do saque é maior que a soma do saldo com o limite
                if (valor <= this.saldo) { // Verifica se o valor do saque é menor que o saldo
                    this.saldo = this.saldo - valor;
                } else {
                    this.limite = (this.limite + this.saldo) - valor;
                    this.saldo = 0;
                }
                return true;
            } else {
                System.out.println("Seu valor de saque é maior que o saldo.");
            }
        } else {
            System.out.println("Você não pode sacar um valor negativo!");
        }
        return false;
    }

    // Metodo para depositar
    public void depositar(float valor) {
        if (valor >= 0) { // Verifica se o valor de deposito é negativo
            this.saldo = this.saldo + valor;
            this.corrigirLimite(); // Verifica a divida do limite para discontar do saldo
        } else {
            System.out.println("Você não pode depositar um valor negativo!");
        }
    }

    // Metodo para transferir
    public void transferir(float valor, Conta conta) {
        if (valor >= 0) { // Verifica se o valor da transferencia é negativo
            if (this.sacar(valor)) { // Chama o metodo saca para retira o valor da conta origem 
                conta.depositar(valor); // Chama o metodo deposito para colocar o valor na conta de destino
                this.corrigirLimite(); // Verifica a divida do limite para discontar do saldo
            } else {
                System.out.println("Não foi possível realizar a transferência.");
            }
        } else {
            System.out.println("Você não pode transferir um valor negativo!");
        }
    }

    // Metodo para debita o valor do limite do saldo 
    private void corrigirLimite() {
        if (this.limite < 200 && this.saldo > 0) { // Verifica se o limite é menor que 200 e se existe saldo positivo 
            float aux;
            aux = 200 - this.limite; // Verifica quanto debitar do saldo
            if (saldo >= aux) { // Verifica se o saldo é maior ou igual do que a divida do limite
                this.saldo = this.saldo - aux;
                this.limite = 200; 
            } else { // Caso contrario, debita o saldo atual, para debita a divida dp limite
                this.limite = this.limite + this.saldo;
                this.saldo = 0;
            }
        }
    }

}
