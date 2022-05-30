package mx.com.od.service;

import javax.ejb.Local;
import mx.com.od.csv.Csv;

/**
 *
 * @author Antonio Pérez Romero
 */
@Local
public interface DataService {

    public Csv getTable(String path, String name) throws Exception;
}
