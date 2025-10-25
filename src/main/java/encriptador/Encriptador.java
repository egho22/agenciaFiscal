/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptador;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Clase que proporciona métodos para encriptar y desencriptar texto utilizando
 * el algoritmo de cifrado simétrico AES.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public class Encriptador {

    /**
     * Algoritmo de cifrado utilizado y su clave correspondiente.
     */
    private static final String ALGORITMO = "AES";
    private static final byte[] llave = "1234567890123456".getBytes();

    /**
     * Encripta una cadena de texto utilizando AES y la codifica en Base64.
     *
     * @param texto El texto plano que se desea encriptar.
     * @return El texto encriptado, codificado en Base64.
     * @throws Exception Si ocurre un error durante el proceso de cifrado.
     */
    public static String encriptar(String texto) throws Exception {
        SecretKeySpec key = new SecretKeySpec(llave, ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(texto.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * Desencripta una cadena codificada en Base64 utilizando AES.
     *
     * @param textoEncriptado El texto encriptado en formato Base64.
     * @return El texto original desencriptado.
     * @throws Exception Si ocurre un error durante el proceso de descifrado.
     */
    public static String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec key = new SecretKeySpec(llave, ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(textoEncriptado);
        return new String(cipher.doFinal(decoded), "UTF-8");
    }
}
