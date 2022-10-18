/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tratix.learnmigratedb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author iqbal al habib
 */
@Entity
@Table(name = "detailp")
@NamedQueries({
    @NamedQuery(name = "Detailp.findAll", query = "SELECT d FROM Detailp d"),
    @NamedQuery(name = "Detailp.findByNama", query = "SELECT d FROM Detailp d WHERE d.nama = :nama"),
    @NamedQuery(name = "Detailp.findById", query = "SELECT d FROM Detailp d WHERE d.id = :id"),
    @NamedQuery(name = "Detailp.findByGerbong", query = "SELECT d FROM Detailp d WHERE d.gerbong = :gerbong"),
    @NamedQuery(name = "Detailp.findByTanggal", query = "SELECT d FROM Detailp d WHERE d.tanggal = :tanggal")})
public class Detailp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "gerbong")
    private String gerbong;
    @Basic(optional = false)
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;

    public Detailp() {
    }

    public Detailp(String id) {
        this.id = id;
    }

    public Detailp(String id, String nama, String gerbong, Date tanggal) {
        this.id = id;
        this.nama = nama;
        this.gerbong = gerbong;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGerbong() {
        return gerbong;
    }

    public void setGerbong(String gerbong) {
        this.gerbong = gerbong;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
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
        if (!(object instanceof Detailp)) {
            return false;
        }
        Detailp other = (Detailp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tratix.learnmigratedb.Detailp[ id=" + id + " ]";
    }
    
}
