package mx.com.od.service;

import java.util.List;
import javax.ejb.Remote;
import mx.com.od.entitymodel.Target;

/**
 *
 * @author Antonio Pérez Romero
 */
@Remote
public interface TargetServiceRemote {

     public List<Target> searchTargetsRemote();

}
