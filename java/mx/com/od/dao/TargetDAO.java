package mx.com.od.dao;

import java.util.List;
import mx.com.od.entitymodel.Target;

/**
 *
 * @author Antonio Pérez Romero
 */
public interface TargetDAO {

    public List<Target> searchTargets();

    public Target searchTargetById(Target target);

    public Target searchTargetByPath(Target target);

    public void addTarget(Target target);

    public void updateTarget(Target target);

    public void deleteTarget(Target target);
}
