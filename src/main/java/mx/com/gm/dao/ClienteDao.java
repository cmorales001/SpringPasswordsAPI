/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.dao;

import java.util.List;
import mx.com.gm.domain.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author KrauserPC
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {

    @Query("SELECT client FROM Cliente client WHERE client.email = :email and client.password = :password")
    public List<Cliente> logginCliente(@Param("email") String email, @Param("password") String password);

}
