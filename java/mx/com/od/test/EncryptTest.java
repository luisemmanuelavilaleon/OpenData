package mx.com.od.test;

import mx.com.od.encrypt.EncryptImpl;

/**
 *
 * @author Antonio Pérez Romero
 */
public class EncryptTest {

    public static void main2(String[] args) {
        testEncrypt();
    }

    public static void testEncrypt() {
        /* getSHA256() & getSHA256Descrypt()
        *
        *  Genera un digest de lo ingresado y devuelve.
        **/
        EncryptImpl encryptImpl = new EncryptImpl();

        String message = "contrasena1234";
        System.out.println(">> Message: " + message);

        String digest = encryptImpl.getSHA256(message);
        System.out.println(">> Digest: " + digest);

        String descrypt = encryptImpl.getSHA256Descrypt(digest);
        System.out.println(">> Descrypt: " + descrypt);
    }
}
