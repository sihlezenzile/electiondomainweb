/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electiondomainweb.repository;

import com.zenzile.electionweb.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sihle
 */
public interface PartyRepository extends JpaRepository<Party, Long>{

    //public Party findOne(Long id);
    
}
