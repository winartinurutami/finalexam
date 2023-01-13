/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExam.finaexam;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author 047
 */
@Entity
@Table(name = "masyarakat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Masyarakat.findAll", query = "SELECT m FROM Masyarakat m"),
    @NamedQuery(name = "Masyarakat.findById", query = "SELECT m FROM Masyarakat m WHERE m.id = :id"),
    @NamedQuery(name = "Masyarakat.findByNik", query = "SELECT m FROM Masyarakat m WHERE m.nik = :nik"),
    @NamedQuery(name = "Masyarakat.findByName", query = "SELECT m FROM Masyarakat m WHERE m.name = :name"),
    @NamedQuery(name = "Masyarakat.findByTl", query = "SELECT m FROM Masyarakat m WHERE m.tl = :tl")})
public class Masyarakat implements Serializable {

    private static final long serialVersionUID = 1L;

    private static void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void load_table() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "nik")
    private String nik;
    @Column(name = "Name")
    private String name;
    @Column(name = "TL")
    @Temporal(TemporalType.DATE)
    private Date tl;
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    public Masyarakat() {
    }

    public Masyarakat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTl() {
        return tl;
    }

    public void setTl(Date tl) {
        this.tl = tl;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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
        if (!(object instanceof Masyarakat)) {
            return false;
        }
        Masyarakat other = (Masyarakat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FinalExam.finaexam.Masyarakat[ id=" + id + " ]";
    }
   
    
   }
   


