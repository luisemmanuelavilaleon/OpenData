package mx.com.od.nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Antonio Pérez Romero
 */
@Data
@NoArgsConstructor
public class File implements FileInterface {

    private Path path;

    public File(Path path) {
        this.path = Paths.get(path.toString());
    }

    @Override
    public boolean isFile() {
        return Files.exists(this.getPath(), new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
    }

    @Override
    public boolean createFile() {
        try {
            Files.createDirectory(this.getPath());
            return true;
        } catch (FileAlreadyExistsException e) {
            System.out.println(" >> Error (File|012) :" + e.getMessage());
        } catch (IOException ex) {
            System.out.println(" >> Error (File|013) :" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean createFileTemp(String prefix) {
        try {
            Path tempModuleLocation = Files.createTempFile(this.getPath(), prefix + "_", ".tmp");
            //tempModuleLocation.toFile().deleteOnExit();
            return true;
        } catch (IOException ex) {
            System.out.println(" >> Error (File|017) :" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean copyFile(Path pathF) {
        try {
            Files.copy(this.getPath(), pathF);
            return true;
        } catch (IOException ex) {
            System.out.println(" >> Error (File|014) :" + ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean moveFile(Path pathF) {
        try {
            Files.move(this.getPath(), pathF);
            return true;
        } catch (IOException ex) {
            System.out.println(" >> Error (File|015) :" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteFile() {
        try {
            Files.deleteIfExists(this.getPath());
            return true;
        } catch (IOException ex) {
            System.out.println(" >> Error (File|016) :" + ex.getMessage());
            return false;
        }
    }
}
