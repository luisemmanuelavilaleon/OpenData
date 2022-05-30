package mx.com.od.encrypt;

/**
 *
 * @author Antonio Pérez Romero
 */
public class EncryptImpl {

    private final Encrypt encrypt;

    public EncryptImpl() {
        this.encrypt = new Encrypt();
    }

    public String getSHA256(String data) {
        return this.encrypt.getSHA256(data);
    }

    public String getSHA256Descrypt(String data) {
        return this.encrypt.getSHA256Descrypt(data);
    }
}
