package mx.com.od.service;

import javax.ejb.Remote;
import mx.com.od.csv.Csv;

/**
 *
 * @author Antonio Pérez Romero
 */
@Remote
public interface DataServiceRemote {

    public Csv getTableRemote(String path, String name) throws Exception;
}
