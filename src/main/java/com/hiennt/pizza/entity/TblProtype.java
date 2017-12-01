package com.hiennt.pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_protype", catalog = "pizzabusinesdb")
public class TblProtype implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer prtId;
    private String prtName;
    private Set<TblProduct> tblProducts = new HashSet<>(0);

    public TblProtype() {
    }

    public TblProtype(Integer prtId, String prtName) {
        this.prtId = prtId;
        this.prtName = prtName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prt_id", unique = true, nullable = false)
    public Integer getPrtId() {
        return prtId;
    }

    public void setPrtId(Integer prtId) {
        this.prtId = prtId;
    }

    @Column(name = "prt_name", length = 100)
    public String getPrtName() {
        return prtName;
    }

    public void setPrtName(String prtName) {
        this.prtName = prtName;
    }

    @OneToMany(mappedBy = "tblProtype", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<TblProduct> getTblProducts() {
        return tblProducts;
    }

    public void setTblProducts(Set<TblProduct> tblProducts) {
        this.tblProducts = tblProducts;
    }
}
