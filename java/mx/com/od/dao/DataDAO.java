package mx.com.od.dao;

import mx.com.od.csv.Csv;

/**
 *
 * @author Antonio Pérez Romero
 */
public interface DataDAO {

    public Csv getTable(String path,String name) throws Exception;
}
