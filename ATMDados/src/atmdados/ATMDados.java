/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmdados;

/**
 *
 * @author 31615961
 */
public class ATMDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String server_address = args[0];
        String server_port = args[1];
        
        BancoProxy bp = new BancoProxy(server_address, server_port);
        
        String operacao = args[2].toLowerCase();
        
        if (operacao.equals("saldo")){
            
            String conta = args[3];
            
            System.out.println("O saldo de sua conta é " + bp.saldo(conta));
        
        }else if (operacao.equals("saque")){
            
            String conta = args[3];
            String valor = args[4];
            
            System.out.println("Saque");
            bp.saque(conta, valor);
            System.out.println("O saldo de sua conta é " + bp.saldo(conta));
            
        }else if(operacao.equals("transferencia")){
            
            String conta1 = args[3];
            String conta2 = args[4];
            String valor = args [5];
            
            System.out.println("Tranferencia");
            bp.transferencia(conta1, conta2, valor);
            System.out.println("O saldo de sua conta origem é " + bp.saldo(conta1));
            System.out.println("O saldo de sua conta destino é " + bp.saldo(conta2));
            
        }else if(operacao.equals("deposito")){
            
            String conta = args[3];
            String valor = args[4];
            
            System.out.println(" Deposito de 500 ");
            bp.deposito(conta, valor);
            System.out.println("O saldo de sua conta é " + bp.saldo(conta));
            
        } 
        
        

        

        
        
        
            
        
        
        

      }

    
}
