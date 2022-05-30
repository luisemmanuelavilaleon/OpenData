package mx.com.od.test;

import java.nio.file.Paths;
import mx.com.od.nio.FileImpl;

/**
 *
 * @author Antonio Pérez Romero
 */
public class FileTest {

    public static void main2(String[] args) {
        FileImpl fileImpl = new FileImpl(Paths.get("C:\\Users\\Antonio Pérez Romero\\Downloads\\tr\\tx.json"));
        System.out.println(fileImpl.isFile());
    }
    
}
