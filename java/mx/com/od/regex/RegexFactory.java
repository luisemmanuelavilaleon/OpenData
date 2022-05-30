package mx.com.od.regex;

/**
 *
 * @author Antonio Pérez Romero
 */
public class RegexFactory {

    public boolean getRegex(String regex, Object obMessage) {
        String message = String.valueOf(obMessage);
        switch (regex) {
            case "isNumber":
                return new Regex("^\\d+$", message).checkRegex();

            case "isDecimal":
                return new Regex("^\\d*\\.\\d+?$", message).checkRegex();

            case "isStringNotSpace":
                return new Regex("^[a-zA-Z0-9]*$", message).checkRegex();

            case "isStringSpace":
                return new Regex("^[a-zA-z0-9 ]*$", message).checkRegex();

            case "isMail":
                return new Regex("^([a-z0-9_\\.\\+-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message).checkRegex();

            case "isStrongPassword":
                return new Regex("(?=(.*[0-9]))(?=.*[\\!@#$%^&*()\\\\char(91)\\char(93){}\\-_+=~`|:;char(34)'<>,./?])(?=.*[a-z])(?=(.*[A-Z]))(?=(.*)).{8,}", message).checkRegex();

            case "isUserName":
                return new Regex("^[a-z0-9_-]{3,16}$", message).checkRegex();

            case "isDate":
                return new Regex("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))", message).checkRegex();

            default:
                return false;
        }
    }
}
