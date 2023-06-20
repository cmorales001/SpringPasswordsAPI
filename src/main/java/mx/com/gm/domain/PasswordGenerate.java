/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.domain;

import java.util.Random;

/**
 *
 * @author KrauserPC
 */
public class PasswordGenerate {

    // generamos un objeto de tipoRandom para la generación de contraseñas
    private Random rdn = new Random();

    public String GenerarPassword(int complejidad,
            Boolean simbolos, Boolean numero) {
        // variables que contienen los caracteres para crear las contraseñas;
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";
        String caracteresEsp = "!@#$%&/()=+?[]";
        char letra;
        String password = "";
        // longitud : numero de caracteres a tomar en cuenta para la creación de la contraseña
        // por defecto la longitud de caracteres
        int longitud = caracteres.length();

        // comprobación de la longitud minima de la contraseña
        if (complejidad < 8) {
            complejidad = 8;
        }
        //se añade los caracteres especiales si se lo solicita
        if (simbolos == true) {
            caracteres += caracteresEsp;
            // longitud : numero de caracteres a tomar en cuenta para la creación de la contraseña
            longitud += caracteresEsp.length();
        }
        // se añade los numeros si se lo solicita
        if (numero == true) {
            caracteres += numeros;
            // longitud : numero de caracteres a tomar en cuenta para la creación de la contraseña
            longitud += numeros.length();
        }
        // se crea la contraseña con caracteres aleatorios en el bucle for
        for (int i = 0; i < complejidad; i++) {
            letra = caracteres.charAt(rdn.nextInt(longitud - 1));
            password += Character.toString(letra);
        }
        // se retorna la contraseña
        return password;
    }

}
