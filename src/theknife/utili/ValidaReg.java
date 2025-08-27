/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.utili;
import java.util.regex.Pattern;

/**
 *
 * @author davim
 */
public class ValidaReg {
    //Dichiarazione e compilazione dell regex per password e email una volta sola in modo da non doverlo compilare ad ogni errore.
    private static final Pattern PATTERN_MAIL = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+[A-Za-z0-9+_.-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    private static final Pattern PATTERN_PASS = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{4,20}$");
    
    /**
     * 
     * @param nome
     * @param cognome
     * @param username
     * @param email
     * @param password
     * @param posizione
     * @param stato
     * @return 
     */
    public static boolean campiPieni(String nome, String cognome, String username, String email, String password, String posizione, String stato) {
        return nome != null && !nome.isBlank() 
                &&  cognome != null && !cognome.isBlank() 
                && username != null && !username.isBlank() 
                && email != null && !email.isBlank() 
                && password != null && !password.isBlank() 
                && posizione != null && !posizione.isBlank()
                && stato != null && !stato.isBlank();
    }
    
    /**
     * 
     * @param mail
     * @return 
     */
    public static boolean mailValida(String mail) {
        return mail != null &&  PATTERN_MAIL.matcher(mail).matches();
    }

    /**
     * 
     * @param pass
     * @return
     */
    public static boolean passValida(String pass) {
        return pass != null && 
                PATTERN_PASS.matcher(pass).matches() 
                && !pass.contains("@");
    }   
}