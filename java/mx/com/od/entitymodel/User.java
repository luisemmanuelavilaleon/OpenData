package mx.com.od.entitymodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID"),
    @NamedQuery(name = "User.findByUserAccountName", query = "SELECT u FROM User u WHERE u.userAccountName = :userAccountName"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByUserRol", query = "SELECT u FROM User u WHERE u.userRol = :userRol")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String userAccountName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String userRol;
    @Lob
    private byte[] userPhoto;
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
    private Person personID;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "userID")
    private List<Target> targetList;

    public User() {
    }

    public User(Integer userID) {
        this.userID = userID;
    }

    public User(Integer userID, String userAccountName, String userPassword, String userRol) {
        this.userID = userID;
        this.userAccountName = userAccountName;
        this.userPassword = userPassword;
        this.userRol = userRol;
    }

    public List<Target> getTargetList() {
        return targetList;
    }

    public void setTargetList(List<Target> targetList) {
        this.targetList = targetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.User[ accountName=" + this.userAccountName + " ]";
    }

}
