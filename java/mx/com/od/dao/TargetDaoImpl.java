package mx.com.od.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.od.entitymodel.Target;

/**
 *
 * @author Antonio Pérez Romero
 */
public class TargetDaoImpl implements TargetDAO {

    @PersistenceContext(unitName = "OpenDataPU")
    EntityManager entityManagerTarget;

    @Override
    public List<Target> searchTargets() {
        return entityManagerTarget.createNamedQuery("Target.findAll").getResultList();
    }

    @Override
    public Target searchTargetById(Target target) {
        return entityManagerTarget.find(Target.class, target.getTargetID());
    }

    @Override
    public Target searchTargetByPath(Target target) {
        return entityManagerTarget.find(Target.class, target.getTargetPath());
    }

    @Override
    public void addTarget(Target target) {
        entityManagerTarget.persist(target);
    }

    @Override
    public void updateTarget(Target target) {
        entityManagerTarget.merge(target);
    }

    @Override
    public void deleteTarget(Target target) {
        entityManagerTarget.remove(entityManagerTarget.merge(target));
    }

}
