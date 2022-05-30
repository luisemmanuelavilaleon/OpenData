package mx.com.od.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.od.csv.Csv;
import mx.com.od.dao.DataDAO;

/**
 *
 * @author Antonio Pérez Romero
 */
@Stateless
public class DataServiceImpl implements DataService, DataServiceRemote {

    @Inject
    private DataDAO tableDAO;

    @Override
    public Csv getTable(String path, String name) throws Exception {
        return tableDAO.getTable(path, name);
    }

    @Override
    public Csv getTableRemote(String path, String name) throws Exception {
        return tableDAO.getTable(path, name);
    }

}
