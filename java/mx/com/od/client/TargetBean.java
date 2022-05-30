package mx.com.od.client;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.od.entitymodel.Target;
import mx.com.od.service.TargetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Antonio Pérez Romero
 */
@Named("targetBean")
@RequestScoped
public class TargetBean {

    Logger log = LogManager.getRootLogger();

    @Inject
    private TargetService targetService;

    private List<Target> targets;

    public TargetBean() {
        log.debug("Iniciando objeto TargetBean");
    }

    @PostConstruct
    public void inicializar() {
        this.targets = targetService.searchTargets();
        log.debug("Targets Recuperados -  ManagedBean: " + this.targets);
    }

}
