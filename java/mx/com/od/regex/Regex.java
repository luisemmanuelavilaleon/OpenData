package mx.com.od.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
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
public class Regex implements RegexInterface {

    private String value;
    private String pattern;

    @Override
    public boolean checkRegex() {
        return Pattern.compile(this.getValue()).matcher(this.getPattern()).matches();
    }
}
