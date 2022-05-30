package mx.com.od.test;

import mx.com.od.regex.RegexFactory;

/**
 *
 * @author Antonio Pérez Romero
 */
public class RegexTest {

    public static void main2(String[] args) {
        RegexFactory regexFactory = new RegexFactory();
        boolean answer = regexFactory.getRegex("isNumber", 1);
        System.out.println(answer);
        
        /*AÑADIR MAS REGEX Y CHECAR EXISTENTES*/
    }
}
