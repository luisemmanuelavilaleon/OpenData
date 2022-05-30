package mx.com.od.json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Antonio Pérez Romero
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class InstructionImpl implements InstructionInterface {

    private Gson gson;
    private Path path;
    private Instruction instruction;

    public InstructionImpl(Path path) {
        this.gson = new Gson();
        this.path = path;
    }

    @Override
    public Instruction jsonToObject() {
        try {
            this.instruction = gson.fromJson(this.bufferReaderToString(Files.newBufferedReader(this.path)), Instruction.class);
        } catch (IOException ex) {
            System.out.println(" >> Error (InstructionImpl|010) :" + ex.getMessage());
        }
        return this.getInstruction();
    }

    @Override
    public String objectToJson(Instruction instruction, Path path) {
        try {
            FileWriter file;
            file = new FileWriter(path.toString());
            file.write(gson.toJson(instruction));
            file.flush();
            file.close();
            return "Succes";
        } catch (IOException ex) {
             System.out.println(" >> Error (InstructionImpl|011) :" + ex.getMessage());
        }
        return "Something went wrong";
    }

    @Override
    public String bufferReaderToString(BufferedReader br) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            String str = stringBuilder.toString();
            br.close();
            return str;
        } catch (IOException ex) {
            System.out.println(" >> Error (InstructionImpl|010) :" + ex.getMessage());
        }

        return "Someting went wrong";
    }
}
