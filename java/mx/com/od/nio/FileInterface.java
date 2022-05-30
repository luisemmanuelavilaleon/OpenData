package mx.com.od.nio;

import java.nio.file.Path;

/**
 *
 * @author Antonio Pérez Romero
 */
public interface FileInterface {

    public boolean isFile();

    public boolean createFile();

    public boolean createFileTemp(String prefix);

    public boolean copyFile(Path pathF);

    public boolean moveFile(Path pathF);

    public boolean deleteFile();
}
