package mx.com.od.nio;

import java.nio.file.Path;
import lombok.Data;

/**
 *
 * @author Antonio Pérez Romero
 */
@Data
public class FileImpl {

    private File file;

    public FileImpl(Path path) {
        file = new File(path);
    }

    public boolean isFile() {
        return this.getFile().isFile();
    }

    public boolean createFile() {
        return this.getFile().createFile();
    }

    public boolean deleteFile() {
        return this.getFile().deleteFile();
    }

    public boolean copyFile(Path pathF) {
        return this.getFile().copyFile(pathF);
    }

    public boolean moveFile(Path pathF) {
        return this.getFile().moveFile(pathF);

    }

    public boolean createFileTemp(Path pathF, String prefix) {
        return this.getFile().createFileTemp(prefix);
    }

}
