/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Cliente;
import mx.com.gm.domain.Password;

/**
 *
 * @author KrauserPC
 */
public interface PasswordService {

    public List<Password> getPasswordsByClient(Long id);
    
    public List<Password> getAllPasswords();

    public void savePassword(Password password);

    public void deletePassword(Password password);

    public Boolean findPassword(Cliente cliente, Password password);
    
    public String getNewSafePasswordDefault();
    
    public String getNewSafePasswordCustom(int length, boolean charEsp, boolean num);
    

}
