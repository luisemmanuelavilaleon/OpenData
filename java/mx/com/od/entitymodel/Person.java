package mx.com.od.entitymodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonID", query = "SELECT p FROM Person p WHERE p.personID = :personID"),
    @NamedQuery(name = "Person.findByPersonName", query = "SELECT p FROM Person p WHERE p.personName = :personName"),
    @NamedQuery(name = "Person.findByPersonLastName", query = "SELECT p FROM Person p WHERE p.personLastName = :personLastName"),
    @NamedQuery(name = "Person.findByPersonGender", query = "SELECT p FROM Person p WHERE p.personGender = :personGender"),
    @NamedQuery(name = "Person.findByPersonAge", query = "SELECT p FROM Person p WHERE p.personAge = :personAge"),
    @NamedQuery(name = "Person.findByPersonCurp", query = "SELECT p FROM Person p WHERE p.personCurp = :personCurp"),
    @NamedQuery(name = "Person.findByPersonRFC", query = "SELECT p FROM Person p WHERE p.personRFC = :personRFC"),
    @NamedQuery(name = "Person.findByPersonEmail", query = "SELECT p FROM Person p WHERE p.personEmail = :personEmail"),
    @NamedQuery(name = "Person.findByPersonPhone", query = "SELECT p FROM Person p WHERE p.personPhone = :personPhone"),
    @NamedQuery(name = "Person.findByPersonCountry", query = "SELECT p FROM Person p WHERE p.personCountry = :personCountry"),
    @NamedQuery(name = "Person.findByPersonCity", query = "SELECT p FROM Person p WHERE p.personCity = :personCity"),
    @NamedQuery(name = "Person.findByPersonPostalCode", query = "SELECT p FROM Person p WHERE p.personPostalCode = :personPostalCode"),
    @NamedQuery(name = "Person.findByPersonBirthDate", query = "SELECT p FROM Person p WHERE p.personBirthDate = :personBirthDate"),
    @NamedQuery(name = "Person.findByPersonHiringDate", query = "SELECT p FROM Person p WHERE p.personHiringDate = :personHiringDate")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer personID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String personName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String personLastName;
    @Basic(optional = false)
    @NotNull
    private Character personGender;
    @Basic(optional = false)
    @NotNull
    private int personAge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String personCurp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String personRFC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String personEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String personPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String personCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String personCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String personPostalCode;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date personBirthDate;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date personHiringDate;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "personID")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personID")
    private List<Target> targetList;

    public Person() {
    }

    public Person(Integer personID) {
        this.personID = personID;
    }

    public Person(Integer personID, String personName, String personLastName, Character personGender, int personAge, String personCurp, String personRFC, String personEmail, String personPhone, String personCountry, String personCity, String personPostalCode, Date personBirthDate, Date personHiringDate) {
        this.personID = personID;
        this.personName = personName;
        this.personLastName = personLastName;
        this.personGender = personGender;
        this.personAge = personAge;
        this.personCurp = personCurp;
        this.personRFC = personRFC;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
        this.personCountry = personCountry;
        this.personCity = personCity;
        this.personPostalCode = personPostalCode;
        this.personBirthDate = personBirthDate;
        this.personHiringDate = personHiringDate;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Person[ id=" + this.personID +  " ]" + "{" + this.personBirthDate+"][" + this.personGender;
    }
    
}
