/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.dao;

import java.util.List;
import mx.com.gm.domain.Password;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author KrauserPC
 */
public interface PasswordDao extends CrudRepository<Password, Long> {

    @Query("SELECT pw FROM Password pw WHERE pw.idCliente = :idCliente")
    public List<Password> passwordCliente(@Param("idCliente") Long idCliente);

    @Query("SELECT CASE WHEN COUNT(pw) > 0 THEN true ELSE false END FROM Password pw WHERE pw.idCliente = :idCliente AND pw.nombre = :nombre")
    public Boolean passwordClienteE(@Param("idCliente") Long idCliente, @Param("nombre") String nombre);

}
