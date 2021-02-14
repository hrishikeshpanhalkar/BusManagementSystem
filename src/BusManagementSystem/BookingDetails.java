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
@Table(name = "booking_details", catalog = "students", schema = "")
@NamedQueries({
    @NamedQuery(name = "BookingDetails.findAll", query = "SELECT b FROM BookingDetails b")
    , @NamedQuery(name = "BookingDetails.findByBookingId", query = "SELECT b FROM BookingDetails b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "BookingDetails.findByFirstName", query = "SELECT b FROM BookingDetails b WHERE b.firstName = :firstName")
    , @NamedQuery(name = "BookingDetails.findByLastName", query = "SELECT b FROM BookingDetails b WHERE b.lastName = :lastName")
    , @NamedQuery(name = "BookingDetails.findByJourneyDate", query = "SELECT b FROM BookingDetails b WHERE b.journeyDate = :journeyDate")
    , @NamedQuery(name = "BookingDetails.findByBusno", query = "SELECT b FROM BookingDetails b WHERE b.busno = :busno")
    , @NamedQuery(name = "BookingDetails.findBySeat", query = "SELECT b FROM BookingDetails b WHERE b.seat = :seat")
    , @NamedQuery(name = "BookingDetails.findByPaid", query = "SELECT b FROM BookingDetails b WHERE b.paid = :paid")
    , @NamedQuery(name = "BookingDetails.findByIdNo", query = "SELECT b FROM BookingDetails b WHERE b.idNo = :idNo")})
public class BookingDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "journey_date")
    @Temporal(TemporalType.DATE)
    private Date journeyDate;
    @Column(name = "busno")
    private String busno;
    @Column(name = "seat")
    private Integer seat;
    @Column(name = "paid")
    private Integer paid;
    @Column(name = "id_no")
    private Integer idNo;

    public BookingDetails() {
    }

    public BookingDetails(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        Integer oldBookingId = this.bookingId;
        this.bookingId = bookingId;
        changeSupport.firePropertyChange("bookingId", oldBookingId, bookingId);
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

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        Date oldJourneyDate = this.journeyDate;
        this.journeyDate = journeyDate;
        changeSupport.firePropertyChange("journeyDate", oldJourneyDate, journeyDate);
    }

    public String getBusno() {
        return busno;
    }

    public void setBusno(String busno) {
        String oldBusno = this.busno;
        this.busno = busno;
        changeSupport.firePropertyChange("busno", oldBusno, busno);
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        Integer oldSeat = this.seat;
        this.seat = seat;
        changeSupport.firePropertyChange("seat", oldSeat, seat);
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        Integer oldPaid = this.paid;
        this.paid = paid;
        changeSupport.firePropertyChange("paid", oldPaid, paid);
    }

    public Integer getIdNo() {
        return idNo;
    }

    public void setIdNo(Integer idNo) {
        Integer oldIdNo = this.idNo;
        this.idNo = idNo;
        changeSupport.firePropertyChange("idNo", oldIdNo, idNo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingDetails)) {
            return false;
        }
        BookingDetails other = (BookingDetails) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusManagementSystem.BookingDetails[ bookingId=" + bookingId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
