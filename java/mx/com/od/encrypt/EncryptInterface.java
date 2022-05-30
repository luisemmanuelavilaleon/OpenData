package mx.com.od.encrypt;

/**
 *
 * @author Antonio Pérez Romero
 */
public interface EncryptInterface {

    public String getSHA256(String data);

    public String getSHA256Descrypt(String data);
}
