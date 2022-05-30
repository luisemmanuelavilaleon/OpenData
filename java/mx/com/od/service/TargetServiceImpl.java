package mx.com.od.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.od.dao.TargetDAO;
import mx.com.od.entitymodel.Target;

/**
 *
 * @author Antonio Pérez Romero
 */
@Stateless
public class TargetServiceImpl implements TargetService, TargetServiceRemote {

    @Inject
    private TargetDAO targetDAO;

    @Override
    public List<Target> searchTargets() {
        return targetDAO.searchTargets();
    }

    @Override
    public List<Target> searchTargetsRemote() {
        return targetDAO.searchTargets();
    }

    @Override
    public Target searchTargetById(Target target) {
        return targetDAO.searchTargetById(target);
    }

    @Override
    public Target searchTargetByPath(Target target) {
        return targetDAO.searchTargetByPath(target);
    }

    @Override
    public void addTarget(Target target) {
        targetDAO.addTarget(target);
    }

    @Override
    public void updateTarget(Target target) {
        targetDAO.updateTarget(target);
    }

    @Override
    public void deleteTarget(Target target) {
        targetDAO.deleteTarget(target);
    }
}
