/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusManagementSystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "emp_details", catalog = "students", schema = "")
@NamedQueries({
    @NamedQuery(name = "EmpDetails.findAll", query = "SELECT e FROM EmpDetails e")
    , @NamedQuery(name = "EmpDetails.findById", query = "SELECT e FROM EmpDetails e WHERE e.id = :id")
    , @NamedQuery(name = "EmpDetails.findByFirstName", query = "SELECT e FROM EmpDetails e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "EmpDetails.findByLastName", query = "SELECT e FROM EmpDetails e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "EmpDetails.findByMob1", query = "SELECT e FROM EmpDetails e WHERE e.mob1 = :mob1")
    , @NamedQuery(name = "EmpDetails.findByMob2", query = "SELECT e FROM EmpDetails e WHERE e.mob2 = :mob2")
    , @NamedQuery(name = "EmpDetails.findByBusNo", query = "SELECT e FROM EmpDetails e WHERE e.busNo = :busNo")})
public class EmpDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mob1")
    private Integer mob1;
    @Column(name = "mob2")
    private Integer mob2;
    @Column(name = "bus_no")
    private String busNo;

    public EmpDetails() {
    }

    public EmpDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public Integer getMob1() {
        return mob1;
    }

    public void setMob1(Integer mob1) {
        Integer oldMob1 = this.mob1;
        this.mob1 = mob1;
        changeSupport.firePropertyChange("mob1", oldMob1, mob1);
    }

    public Integer getMob2() {
        return mob2;
    }

    public void setMob2(Integer mob2) {
        Integer oldMob2 = this.mob2;
        this.mob2 = mob2;
        changeSupport.firePropertyChange("mob2", oldMob2, mob2);
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        String oldBusNo = this.busNo;
        this.busNo = busNo;
        changeSupport.firePropertyChange("busNo", oldBusNo, busNo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpDetails)) {
            return false;
        }
        EmpDetails other = (EmpDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusManagementSystem.EmpDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
