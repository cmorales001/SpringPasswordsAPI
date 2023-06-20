/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Cliente;

/**
 *
 * @author KrauserPC
 */
public interface ClienteService {
    
    public List<Cliente> getAllClients();
    
    public void saveClient(Cliente cliente);
    
    public Cliente getClientById(Long idCliente);
    
    public Cliente LogginClient(Cliente cliente);
    
}
