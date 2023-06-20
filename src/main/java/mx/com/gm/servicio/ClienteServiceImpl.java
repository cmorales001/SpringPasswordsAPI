/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.servicio;

import org.springframework.stereotype.Service;

import java.util.List;
import mx.com.gm.dao.ClienteDao;
import mx.com.gm.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteDao clienteDao;
    
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> getAllClients() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Transactional
    @Override
    public void saveClient(Cliente cliente) {
        clienteDao.save(cliente);
    }

   
    @Transactional(readOnly = true)
    @Override
    public Cliente getClientById(Long idCliente) {
        
        return clienteDao.findById(idCliente).orElse(null);
    }

    @Override
    public Cliente LogginClient(Cliente cliente) {
        List<Cliente> clientes = clienteDao.logginCliente(cliente.getEmail(), cliente.getPassword());
        if(!clientes.isEmpty()){
            return clientes.get(0);
        }
        return null;
    }

    
}
