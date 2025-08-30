/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.utili;
import java.util.regex.Pattern;

/**
 * Classe per la validazione di campi utente come email e password.
 * <p>
 * Fornisce metodi statici per verificare che i campi obbligatori siano pieni,
 * che un'email abbia un formato valido e che una password rispetti determinati criteri.
 * 
 * @see Pattern
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class ValidaReg {
    /** 
     * Pattern regex precompilato per validare l'email.
     * <p>
     * Verifica la struttura generale di un indirizzo email valido. {@code PATTERN_MAIL}
     */
    private static final Pattern PATTERN_MAIL = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+[A-Za-z0-9+_.-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    
    /** 
     * Pattern regex precompilato per validare la password.
     * <p>
     * Richiede almeno una lettera minuscola, una maiuscola, un numero e lunghezza tra 4 e 20 caratteri. {@code PATTERN_PASS}
     */
    private static final Pattern PATTERN_PASS = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{4,20}$");
    
    /**
     * Verifica che tutti i campi obbligatori siano pieni e non nulli.
     * 
     * @param nome nome dell'utente
     * @param cognome cognome dell'utente
     * @param username username scelto dall'utente
     * @param email indirizzo email
     * @param password password
     * @param posizione città dell'utente
     * @param stato stato dell'utente
     * @return true se tutti i campi non sono nulli e non sono vuoti, false altrimenti
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
     * Verifica che una stringa rappresenti un'email valida.
     * 
     * @param mail stringa da validare come email
     * @return true se la stringa corrisponde al pattern email, false altrimenti
     * @see #PATTERN_MAIL
     */
    public static boolean mailValida(String mail) {
        return mail != null &&  PATTERN_MAIL.matcher(mail).matches();
    }

    /**
     * Verifica che una password sia valida secondo i criteri definiti.
     * <p>
     * La password deve contenere almeno una lettera minuscola, una maiuscola, un numero, avere lunghezza compresa tra 4 e 20 caratteri 
     * e non contenere il carattere '@'.
     * 
     * @param pass password da validare
     * @return true se la password è valida, false altrimenti
     * @see #PATTERN_PASS
     */
    public static boolean passValida(String pass) {
        return pass != null && 
                PATTERN_PASS.matcher(pass).matches() 
                && !pass.contains("@");
    }   
}