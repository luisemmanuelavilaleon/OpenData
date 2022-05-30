package mx.com.od.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author Antonio Pérez Romero
 */
public interface InstructionInterface {

    public Instruction jsonToObject();

    public String objectToJson(Instruction instruction,Path path);

    public String bufferReaderToString(BufferedReader br);
}
