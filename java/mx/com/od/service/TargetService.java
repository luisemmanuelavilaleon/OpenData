package mx.com.od.service;

import java.util.List;
import javax.ejb.Local;
import mx.com.od.entitymodel.Target;

/**
 *
 * @author Antonio Pérez Romero
 */
@Local
public interface TargetService {

    public List<Target> searchTargets();

    public Target searchTargetById(Target target);

    public Target searchTargetByPath(Target target);

    public void addTarget(Target target);

    public void updateTarget(Target target);

    public void deleteTarget(Target target);
}
