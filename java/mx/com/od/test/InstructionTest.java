package mx.com.od.test;

import java.io.IOException;
import java.nio.file.Paths;
import mx.com.od.json.Instruction;
import mx.com.od.json.InstructionImpl;

/**
 *
 * @author Antonio Pérez Romero
 */
public class InstructionTest {

    public static void mai2(String[] args) throws IOException {
        InstructionImpl instructionImpl = new InstructionImpl(Paths.get("C:\\OpenDataProject\\OpenData\\src\\main\\resources\\test\\pythonInstruction.json"));
        //testJsonToObject(instructionImpl);
        //testObjectToJson(instructionImpl);
        
        /*FALTA VALIDAR SI EXISTE LOS FICHEROS*/
    }

    public static void testJsonToObject(InstructionImpl instructionImpl) {
        /* jsonToObject()
        *   
        *  Convierte un JSON File a un Objeto Instrucción
        **/
        Instruction instruction = instructionImpl.jsonToObject();
        System.out.println(instruction.toString());

    }

    public static void testObjectToJson(InstructionImpl instructionImpl) {
        /* objectToJson()
        *   
        *  Convierte un Objeto Instrucción a un JSON File
        **/
        System.out.println(instructionImpl.objectToJson(new Instruction("Java", "14"), Paths.get("C:\\Users\\Antonio Pérez Romero\\Downloads\\tr\\test2.json")));
    }
}
