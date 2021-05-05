/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Principal {
    public static void main(String[] args) { 
        // Estanciamento do objeto c1 e c2
        Conta c1 = new Conta();
        Conta c2 = new Conta();
        
        System.out.println("O limite de 200 é prédefinido para todas as contas.");
        // Carregando valores
        c1.setId(1);
        c1.setNome("Jhenmy");
        c1.setSaldo(1000);
        
        c2.setId(2);
        c2.setNome("Pedro");
        c2.setSaldo(2000);
        
        // Utilizando os metodos sacar, depositar e transferir
        c1.sacar(900);
        c2.sacar(2100);
        c1.depositar(600);
        c1.transferir(300, c2); 
        c2.depositar(100);
        
        // Mostrando na tela o resultado final
        System.out.println("Primeira conta");
        System.out.println("id: "+c1.getId());
        System.out.println("nome: "+c1.getNome());
        System.out.println("saldo: "+c1.getSaldo());
        System.out.println("limite: "+c1.getLimite());
        
        
        System.out.println("\nSegunda conta");
        System.out.println("id: "+c2.getId());
        System.out.println("nome: "+c2.getNome());
        System.out.println("saldo: "+c2.getSaldo());
        System.out.println("limite: "+c2.getLimite());
    }
}
