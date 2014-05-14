/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author sihle
 */
@Embeddable
public class Deputy implements Serializable {
    private String dname;
    private String dsurname;
    private Long dparty;

    private Deputy() {
    }

    private Deputy(InnerDeputy in) 
    {
        dname = in.dname;
        dsurname = in.dsurname;
        dparty = in.dparty;
        
        
    }
    
    public static class InnerDeputy
    {
        private String dname;
        private String dsurname;
        private Long dparty;
        
        public InnerDeputy surname(String s)
        {
            dsurname = s;
            return this;
        }
        
        public InnerDeputy party(Long p)
        {
            dparty = p;
            return this;
        }
        
        public InnerDeputy(String n) {
            
            this.dname = n;

        }
        
        public InnerDeputy president(President pr)
        {
            dname = pr.getName();
            dsurname = pr.getSurname();
            dparty = pr.getParty();
            return this;
        }
        
        public Deputy innerPresident()
        {
            return new Deputy(this);
        }
    }

    public String getName() {
        return dname;
    }

    public String getSurname() {
        return dsurname;
    }

    public Long getParty() {
        return dparty;
    }
    
    
}
