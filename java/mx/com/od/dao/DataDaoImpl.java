package mx.com.od.dao;

import java.nio.file.Paths;
import mx.com.od.csv.Csv;
import mx.com.od.csv.CsvFactory;

/**
 *
 * @author Antonio Pérez Romero
 */
public class DataDaoImpl implements DataDAO {

    @Override
    public Csv getTable(String path, String name) throws Exception {
        CsvFactory csvFactory = new CsvFactory(Paths.get(path), name);
        Csv csv = csvFactory.readData("readAll");
        return csv;
    }

}
