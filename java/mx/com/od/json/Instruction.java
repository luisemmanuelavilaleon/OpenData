package mx.com.od.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Antonio Pérez Romero
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Instruction {

    private String language;
    private String instruction;
}
