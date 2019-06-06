/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidordados;

import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author 31615961
 */
@Singleton
@Path("operacoes")
public class Operacoes {
 @Context
 private UriInfo context;
 int contas[] = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};

 /**
 * Creates a new instance of servidordedados
 */
 public Operacoes() {
 }
 /**
 * Retrieves representation of an instance of servidordados.Operacoes
 * @return an instance of java.lang.String
 */
 @GET
 @Produces("text/plain")
 @Path("/saldo/{valor}")
 public String saldo(@PathParam("valor") String valor_) {
 System.out.println("Servidor de Dados - Enviado saldo da conta " + valor_ + " com o valor de " + contas[Integer.parseInt(valor_)]);
 return Integer.toString(contas[Integer.parseInt(valor_)]);
 }
 /**
 * PUT method for updating or creating an instance of Operacoes
 * @param content representation for the resource
 * @return an HTTP response with content of the updated or created resource.
 */
 @GET
 @Produces("text/plain")
 @Path("/deposito/{conta}/{valor}")
 public void deposito(@PathParam("conta") String conta_, @PathParam("valor") String valor_) {
 System.out.println("Servidor de Dados - entrou no deposito");
 int valor = Integer.parseInt(valor_);
 contas[Integer.parseInt(conta_)] += valor;
 System.out.println("Servidor de Dados - Alterado saldo da conta para o valor de " + contas[Integer.parseInt(conta_)]);
 }
 
 @GET
 @Produces("text/plain")
 @Path("/transferencia/{conta1}/{conta2}/{valor}")
 public void transferencia(@PathParam("conta1") String conta1_, @PathParam("conta2") String conta2_, @PathParam("valor") String valor_) {
 System.out.println("Servidor de Dados - entrou na transferencia");
 int valor = Integer.parseInt(valor_);
 contas[Integer.parseInt(conta1_)] -= valor;
 contas[Integer.parseInt(conta2_)] += valor;
 System.out.println("Servidor de Dados - Alterado saldo da conta origem para o valor de " + contas[Integer.parseInt(conta1_)]);
 System.out.println("Servidor de Dados - Alterado saldo da conta destino para o valor de " + contas[Integer.parseInt(conta2_)]);
 }
 
 @GET
 @Produces("text/plain")
 @Path("/saque/{conta}/{valor}")
 public void saque(@PathParam("conta") String conta_, @PathParam("valor") String valor_) {
 System.out.println("Servidor de Dados - entrou no Saque");
 int valor = Integer.parseInt(valor_);
 contas[Integer.parseInt(conta_)] -= valor;
 System.out.println("Servidor de Dados - Alterado saldo da conta para o valor de " + contas[Integer.parseInt(conta_)]);
 }
 
}
