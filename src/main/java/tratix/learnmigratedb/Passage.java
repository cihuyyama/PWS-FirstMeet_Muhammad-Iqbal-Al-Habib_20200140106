/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tratix.learnmigratedb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author iqbal al habib
 */
@Entity
@Table(name = "passage")
@NamedQueries({
    @NamedQuery(name = "Passage.findAll", query = "SELECT p FROM Passage p"),
    @NamedQuery(name = "Passage.findByTipeId", query = "SELECT p FROM Passage p WHERE p.tipeId = :tipeId"),
    @NamedQuery(name = "Passage.findByTipePenumpang", query = "SELECT p FROM Passage p WHERE p.tipePenumpang = :tipePenumpang")})
public class Passage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipeId")
    private String tipeId;
    @Column(name = "tipe_penumpang")
    private String tipePenumpang;

    public Passage() {
    }

    public Passage(String tipeId) {
        this.tipeId = tipeId;
    }

    public String getTipeId() {
        return tipeId;
    }

    public void setTipeId(String tipeId) {
        this.tipeId = tipeId;
    }

    public String getTipePenumpang() {
        return tipePenumpang;
    }

    public void setTipePenumpang(String tipePenumpang) {
        this.tipePenumpang = tipePenumpang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipeId != null ? tipeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passage)) {
            return false;
        }
        Passage other = (Passage) object;
        if ((this.tipeId == null && other.tipeId != null) || (this.tipeId != null && !this.tipeId.equals(other.tipeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tratix.learnmigratedb.Passage[ tipeId=" + tipeId + " ]";
    }
    
}
