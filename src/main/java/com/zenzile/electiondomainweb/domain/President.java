/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author sihle
 */
@Embeddable
public class President implements Serializable {
    
    private String pname;
    private String psurname;
    private Long pparty;

    private President() {
    }

    private President(InnerPresident in) {
        pname = in.pname;
        psurname = in.psurname;
        pparty = in.pparty;
    }
    
    
    
    public static class InnerPresident
    {
        private String pname;
        private String psurname;
        private Long pparty;
        
        public InnerPresident name(String n)
        {
            pname = n;
            return this;
        }
        
        public InnerPresident surname(String s)
        {
            psurname = s;
            return this;
        }
        
        public InnerPresident party(Long p)
        {
            pparty = p;
            return this;
        }
        
        public InnerPresident(Long p) {
            
            this.pparty = p;
        }
        
        public InnerPresident president(President pr)
        {
            pname = pr.getName();
            psurname = pr.getSurname();
            pparty = pr.getParty();
            return this;
        }
        
        public President innerPresident()
        {
            return new President(this);
        }
    }

    public String getName() {
        return pname;
    }

    public String getSurname() {
        return psurname;
    }

    public Long getParty() {
        return pparty;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.pname);
        hash = 97 * hash + Objects.hashCode(this.psurname);
        hash = 97 * hash + Objects.hashCode(this.pparty);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final President other = (President) obj;
        if (!Objects.equals(this.pname, other.pname)) {
            return false;
        }
        if (!Objects.equals(this.psurname, other.psurname)) {
            return false;
        }
        if (!Objects.equals(this.pparty, other.pparty)) {
            return false;
        }
        return true;
    }
    
    
}
