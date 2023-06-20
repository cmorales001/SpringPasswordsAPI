/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PasswordDao;
import mx.com.gm.domain.Cliente;
import mx.com.gm.domain.Password;
import mx.com.gm.domain.PasswordGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KrauserPC
 */
@Service
public class PasswordServiceImpl implements PasswordService{
    
    @Autowired
    private PasswordDao passwordDao;
  
    private PasswordGenerate passwordGenerate;

    @Transactional(readOnly = true)
    @Override
    public List<Password> getPasswordsByClient(Long id) {
        return passwordDao.passwordCliente(id);
    }

    @Transactional
    @Override
    public void savePassword(Password password) {
        passwordDao.save(password);
    }

    @Transactional
    @Override
    public void deletePassword(Password password) {
        passwordDao.delete(password);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Password> getAllPasswords() {
        return (List<Password>) passwordDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean findPassword(Cliente cliente,Password password) {
        
        return passwordDao.passwordClienteE(cliente.getIdCliente(), password.getNombre());
    }

    @Override
    public String getNewSafePasswordDefault() {
        passwordGenerate = new PasswordGenerate();
        return passwordGenerate.GenerarPassword(8, true, true);
    }

    

    @Override
    public String getNewSafePasswordCustom(int length, boolean charEsp, boolean num) {
        passwordGenerate = new PasswordGenerate();
        return passwordGenerate.GenerarPassword(length,  charEsp,  num);
    }
    
}
