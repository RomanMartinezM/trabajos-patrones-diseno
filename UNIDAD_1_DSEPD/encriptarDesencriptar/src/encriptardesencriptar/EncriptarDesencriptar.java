/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptardesencriptar;

import java.security.Key;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author lithium
 */
public class EncriptarDesencriptar {
private static String  ENCRYPT_KEY="clave-compartida";
 
private static String encript(String text) throws Exception {  
    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
 
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
 
    byte[] encrypted = cipher.doFinal(text.getBytes());
         
    return Base64.getEncoder().encodeToString(encrypted);
    }
 
private static String decrypt(String encrypted) throws Exception {
    byte[] encryptedBytes=Base64.getDecoder().decode( encrypted.replace("\n", "") );
         
    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
 
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, aesKey);
 
    String decrypted = new String(cipher.doFinal(encryptedBytes));
         
    return decrypted;
    }
    public static void main(String[] args) {
   
     byte[] encodedBytes = Base64.getEncoder().encode("Comer on toos".getBytes());
    System.out.println("encodedBytes " + new String(encodedBytes));
    byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
    System.out.println("decodedBytes " + new String(decodedBytes));

    
    System.out.println("--------------------------------\n\n");
    String s[]={"Comer on tos"};
    String enc[] = new String[1];
    byte[] encodedBytes2 = Base64.getEncoder().encode(s[0].getBytes());
    enc[0]=new String(encodedBytes2);
    System.out.println("ENCRIPTADO: " +enc[0]);
    //System.out.println("encodedBytes " + new String(encodedBytes2));
    byte[] decodedBytes2 = Base64.getDecoder().decode(encodedBytes2);
    System.out.println("decodedBytes " + new String(decodedBytes2));

    
 
    /*
        try {
        System.out.println("encriptado:     " + encript(ENCRYPT_KEY));
    } catch (Exception ex) {
        Logger.getLogger(EncriptarDesencriptar.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        System.out.println("desencriptado:      " + decrypt(ENCRYPT_KEY));
    } catch (Exception ex) {
        Logger.getLogger(EncriptarDesencriptar.class.getName()).log(Level.SEVERE, null, ex);
    }
    */
        
    }
    
}
