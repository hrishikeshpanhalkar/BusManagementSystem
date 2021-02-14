/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusManagementSystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "bus_details", catalog = "students", schema = "")
@NamedQueries({
    @NamedQuery(name = "BusDetails.findAll", query = "SELECT b FROM BusDetails b")
    , @NamedQuery(name = "BusDetails.findById", query = "SELECT b FROM BusDetails b WHERE b.id = :id")
    , @NamedQuery(name = "BusDetails.findByBusno", query = "SELECT b FROM BusDetails b WHERE b.busno = :busno")
    , @NamedQuery(name = "BusDetails.findByMovement", query = "SELECT b FROM BusDetails b WHERE b.movement = :movement")
    , @NamedQuery(name = "BusDetails.findByBusSource", query = "SELECT b FROM BusDetails b WHERE b.busSource = :busSource")
    , @NamedQuery(name = "BusDetails.findByBusdest", query = "SELECT b FROM BusDetails b WHERE b.busdest = :busdest")
    , @NamedQuery(name = "BusDetails.findByDepartDate", query = "SELECT b FROM BusDetails b WHERE b.departDate = :departDate")
    , @NamedQuery(name = "BusDetails.findByDeparttime", query = "SELECT b FROM BusDetails b WHERE b.departtime = :departtime")
    , @NamedQuery(name = "BusDetails.findByPrice", query = "SELECT b FROM BusDetails b WHERE b.price = :price")
    , @NamedQuery(name = "BusDetails.findByTotalseat", query = "SELECT b FROM BusDetails b WHERE b.totalseat = :totalseat")})
public class BusDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Bus_no")
    private String busno;
    @Column(name = "Movement")
    private String movement;
    @Column(name = "Bus_Source")
    private String busSource;
    @Column(name = "Bus_dest")
    private String busdest;
    @Column(name = "Depart_Date")
    @Temporal(TemporalType.DATE)
    private Date departDate;
    @Column(name = "Depart_time")
    private String departtime;
    @Column(name = "price")
    private Integer price;
    @Column(name = "Total_seat")
    private Integer totalseat;

    public BusDetails() {
    }

    public BusDetails(Integer id) {
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

    public String getBusno() {
        return busno;
    }

    public void setBusno(String busno) {
        String oldBusno = this.busno;
        this.busno = busno;
        changeSupport.firePropertyChange("busno", oldBusno, busno);
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        String oldMovement = this.movement;
        this.movement = movement;
        changeSupport.firePropertyChange("movement", oldMovement, movement);
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        String oldBusSource = this.busSource;
        this.busSource = busSource;
        changeSupport.firePropertyChange("busSource", oldBusSource, busSource);
    }

    public String getBusdest() {
        return busdest;
    }

    public void setBusdest(String busdest) {
        String oldBusdest = this.busdest;
        this.busdest = busdest;
        changeSupport.firePropertyChange("busdest", oldBusdest, busdest);
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        Date oldDepartDate = this.departDate;
        this.departDate = departDate;
        changeSupport.firePropertyChange("departDate", oldDepartDate, departDate);
    }

    public String getDeparttime() {
        return departtime;
    }

    public void setDeparttime(String departtime) {
        String oldDeparttime = this.departtime;
        this.departtime = departtime;
        changeSupport.firePropertyChange("departtime", oldDeparttime, departtime);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        Integer oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Integer getTotalseat() {
        return totalseat;
    }

    public void setTotalseat(Integer totalseat) {
        Integer oldTotalseat = this.totalseat;
        this.totalseat = totalseat;
        changeSupport.firePropertyChange("totalseat", oldTotalseat, totalseat);
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
        if (!(object instanceof BusDetails)) {
            return false;
        }
        BusDetails other = (BusDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusManagementSystem.BusDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
