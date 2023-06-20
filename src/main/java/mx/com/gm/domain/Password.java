/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author KrauserPC
 */
@Data
@Entity
@Table(name = "password")
public class Password implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPassword;
    
    @NotNull
    private Long idCliente;
    
    @NotEmpty
    // identificador de la contraseña
    private String nombre;
    
    // contraseña asignada
    @NotEmpty
    private String pssword;
    
}
