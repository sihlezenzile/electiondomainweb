/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sihle
 */
@Entity
public class Party implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    @Embedded
    private President presidentId;
    
    @Embedded
    private Deputy deputyId;
    @Column(unique = true)
    private String abbreviation;
    @Column(unique = true)
    private String name;


    public Party() {
    }

    private Party(InnerParty inner)
    {
        id = inner.id;
        abbreviation = inner.abbreviation;
        name = inner.name;
        presidentId = inner.presidentId;
        deputyId = inner.deputyId;
    }
    public static class InnerParty
    {
        private Long id;
        private String abbreviation;
        private String name;
        private President presidentId;
        private Deputy deputyId;
 
        public InnerParty(String abbre) {
            this.abbreviation = abbre;
        }
        
        public InnerParty id(Long value) {
            id = value;
            return this;
        }

        public InnerParty name(String nm) {
            name = nm;
            return this;
        }
        
        public InnerParty president(President pre) {
            presidentId = pre;
            return this;
        }
        
        public InnerParty deputyId(Deputy dep) {
            deputyId = dep;
            return this;
        }
        
        public InnerParty party(Party in)
        {
            id = in.getId();
            abbreviation = in.getAbbreviation();
            name = in.getName();
            deputyId = in.getDeputyId();
            presidentId = in.getPresidentId();
            return this;
        }
        public Party innerParty()
        {
            return new Party(this);
        }
    }
    
    public Long getId() {
        return id;
    }
    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public President getPresidentId() {
        return presidentId;
    }

    public Deputy getDeputyId() {
        return deputyId;
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
        if (!(object instanceof Party)) {
            return false;
        }
        Party other = (Party) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Party[ id=" + id + " ]";
    }
    
}
