/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

import java.util.List;
import mx.com.gm.domain.Password;
import mx.com.gm.servicio.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KrauserPC
 */
@RestController
@RequestMapping("/api/v1/password")
public class ControllerRestPassword {
    
    @Autowired
    private PasswordService passwordService;
    
    
    // peticiones para contraseñas
    
    // metodo que guarda contraseña de un usuario en especifico
    @PostMapping("/newPassword")
    public void newPassword(@RequestBody Password password){
        passwordService.savePassword(password);
    }
    
    // metodo que genera una nueva contraseña segura por defecto con longitud de 8 caracteres,  caracteres especiales, numeros y letras mayusculas y minusculas
    @GetMapping("/newsafepassworddefault")
    public String passwordgeneratedafult(){
        return passwordService.getNewSafePasswordDefault() ;
    }
    
    // metodo que genera una nueva contraseña segura personalizada
    @GetMapping("/newsafepasswordcustom/{length}/{CharEsp}/{num}")
    public String passwordgeneratecustom(@PathVariable("length")int length,@PathVariable("CharEsp") boolean CharEsp, @PathVariable("num") boolean num ){
        return passwordService.getNewSafePasswordCustom(length, CharEsp, num) ;
    }
    
    
    
    // metodo para obtener las contraseñas de un usuario
    @GetMapping("/getpasswords/{id}")
    public List<Password> getPasswordsByClient(@PathVariable("id") Long id) {
        return passwordService.getPasswordsByClient(id);
    }
    
    // metodo para obtener todas las contraseñas 
    @GetMapping("/getpasswords")
    public List<Password> getPasswords() {
        return passwordService.getAllPasswords();
    }
    
    //metodo para modificar una contraseña 
    @PostMapping("/updatepassword")
    public void updatePassword(@RequestBody Password password){
        passwordService.savePassword(password);
    }
}
