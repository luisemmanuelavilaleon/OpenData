package mx.com.od.client;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import mx.com.od.csv.Csv;
import mx.com.od.service.DataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@Named("dataBean")
@RequestScoped
public class DataBean {

    private String[] selectedOptions;
    private String[] kernel = {"linear","poly","rbf","sigmoid","precomputed"};
    private String[] criterion = {"gini","entropy","log_loss"};
    Logger log = LogManager.getRootLogger();

    @Inject
    private DataService dataService;

    Csv data;

    public DataBean() {
        log.debug("Iniciando objeto DataBean");
    }

    @PostConstruct
    public void inicializar() {
        try {
            this.data = new Csv();
            //CHANGE TO AN ACTION METHOD
            this.data = dataService.getTable("C:\\Open_Data_Project\\OpenData\\src\\main\\resources\\test\\Admission_Predict.csv", "Admission Predict");
            data.csvInfo();
            log.debug("Personas Recuperadas -  ManagedBean: " + this.data);
        } catch (Exception ex) {
            System.out.println(" >> Error (DataBean|020) :" + ex.getMessage());
        }

    }

    public String[] getSelectedOptions() {
        return selectedOptions;
    }
}
