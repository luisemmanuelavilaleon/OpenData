package mx.com.od.csv;

import java.awt.Point;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Antonio Pérez Romero
 */
public interface CsvInterface {

    public List<String[]> csvReadAll(Reader reader) throws Exception;

    public List<String[]> csvOneByOne(Reader reader) throws Exception;

    public void csvWriterOneByOne(List<String[]> stringArray, Path path) throws Exception;

    public void csvWriterAll(List<String[]> stringArray, Path path) throws Exception;

    public String csvFindColumn(int columnIndex);

    public String[] csvFindRow(int rowIndex);

    public String csvFinCell(Point p);

    public boolean csvIsColumn(int columnIndex);

    public boolean csvIsRow(int rowIndex);

    public boolean csvIsCell(Point p);

    public String csvChangeCellValue(Point p, String newValue,Path path);

    public void csvInfo();
}
