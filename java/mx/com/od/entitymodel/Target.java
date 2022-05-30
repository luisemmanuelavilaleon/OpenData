package mx.com.od.entitymodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Antonio Pérez Romero
 */
@Data
@Entity
@NamedQueries({
    @NamedQuery(name = "Target.findAll", query = "SELECT t FROM Target t"),
    @NamedQuery(name = "Target.findByTargetID", query = "SELECT t FROM Target t WHERE t.targetID = :targetID"),
    @NamedQuery(name = "Target.findByTargetPath", query = "SELECT t FROM Target t WHERE t.targetPath = :targetPath")})
public class Target implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer targetID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String targetPath;
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Person personID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private User userID;

    public Target() {
    }

    public Target(Integer targetID) {
        this.targetID = targetID;
    }

    public Target(Integer targetID, String targetPath) {
        this.targetID = targetID;
        this.targetPath = targetPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (targetID != null ? targetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Target)) {
            return false;
        }
        Target other = (Target) object;
        if ((this.targetID == null && other.targetID != null) || (this.targetID != null && !this.targetID.equals(other.targetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Target[ targetID=" + targetID + " ]";
    }
    
}
