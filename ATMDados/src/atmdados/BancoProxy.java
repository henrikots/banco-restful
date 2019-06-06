/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmdados;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:Operacoes [operacoes]<br>
 * USAGE:
 * <pre>
 *        BancoProxy client = new BancoProxy();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author 31615961
 */
public class BancoProxy {

    private WebTarget webTarget;
    private Client client;
    private static String BASE_URI;

    public BancoProxy(String server_address, String server_port) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        BASE_URI = "http://" + server_address + ":" + server_port + "/lab05/webresources";
        webTarget = client.target(BASE_URI).path("operacoes");
    }

    public String deposito(String conta, String valor) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deposito/{0}/{1}",new Object[]{conta,valor}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public String saldo(String valor) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("saldo/{0}", new Object[]{valor}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }
    
    public String transferencia(String conta_origem, String conta_destino, String valor) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("transferencia/{0}/{1}/{2}", new Object[]{conta_origem,conta_destino, valor}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public String saque(String conta, String valor) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("saque/{0}/{1}", new Object[]{conta, valor}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }
    
    public void close() {
        client.close();
    }
    
}
