/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

import java.util.List;
import mx.com.gm.domain.Cliente;
import mx.com.gm.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class ControllerRestClient {

    @Autowired
    private ClienteService clienteService;
    
    
    
    @GetMapping("/getclients")
    public List<Cliente> getAllUsers() {
        return clienteService.getAllClients();
    }
    
    @GetMapping("/getclient/{id}")
    public Cliente getUsersByID(@PathVariable("id") Long id) {
        return clienteService.getClientById(id);
    }
    
    @PostMapping("/newclient")
    public void newClient(@RequestBody Cliente cliente){
        clienteService.saveClient(cliente);
    }
    
    @PostMapping("/accessclient")
    public Cliente LogginCliente(@RequestBody Cliente cliente){
        return clienteService.LogginClient(cliente);
    }
    
    
    
   
    
    
    
    

}
