/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electiondomainweb.test.repository;

import com.zenzile.electiondomainweb.app.conf.ConnectionConfig;
import com.zenzile.electionweb.domain.Deputy;
import com.zenzile.electionweb.domain.Party;
import com.zenzile.electionweb.domain.President;
import com.zenzile.electiondomainweb.repository.PartyRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author sihle
 */
public class PartyRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private PartyRepository repo;
    private Deputy deputy;
    private President president;
    public PartyRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hellPersono() {}
    @Test
    public void createParty()
    {   
        repo = ctx.getBean(PartyRepository.class);
        
        deputy = new Deputy.InnerDeputy("Hellen")
                .surname("Zille")
                .party(1L)
                
                .innerPresident();
        president = new President.InnerPresident(1L)
                .name("Lindiwe")
                .surname("Mazibuko")
                .innerPresident();
        
        Party part = new Party.InnerParty("DA")
                .name("Democratic Alliance")
                .deputyId(deputy)
                .president(president)
                .innerParty();
         repo.save(part);
         id = part.getId();
         Assert.assertNotNull(part);
    }
    
    @Test(dependsOnMethods = "createParty")
    public void readParty(){
         repo = ctx.getBean(PartyRepository.class);
         Party part = repo.findOne(id);
         Assert.assertEquals(part.getName(), "DA");
    }
    
    @Test(dependsOnMethods = "readParty")
    private void updatePerson(){
         repo = ctx.getBean(PartyRepository.class);
         Party part = repo.findOne(id);
         Party updatedPerson = new Party.InnerParty("Democratic Alliance")
                 .party(part)
                 .name("Demo Ally")
                 .innerParty();
        
         repo.save(updatedPerson);
         
         Party updated = repo.findOne(id);
         Assert.assertEquals(updated.getName(), "Demo Ally");
    } 
    
      @Test(dependsOnMethods = "updateParty")
     private void deletePerson(){
         repo = ctx.getBean(PartyRepository.class);
         Party person = repo.findOne(id);
         repo.delete(person);
         
         Party del = repo.findOne(id);
         
         Assert.assertNull(del);
         
         
     }
     
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        //ctx = new AnnotationConfigApplicationContext();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
