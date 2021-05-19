package com.mycompany.app;

import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import UI.ui;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;

import org.junit.Test;

import Domain.Nota;
import Domain.Student;
import Domain.TemaLab;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class GradeTest 
{
    StudentValidator vs=new StudentValidator();
    TemaLabValidator vt=new TemaLabValidator();
    NotaValidator vn=new NotaValidator();
    StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
    TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
    NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
    StudentXMLService stsrv=new StudentXMLService(strepo);
    TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
    NotaXMLService ntsrv=new NotaXMLService(ntrepo);
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addStudentTestCase1()
    {
        
        ui.vs = vs;
        ui.vt = vt;
        ui.vn = vn;
       
        String[] params={"22","nume1","1","email@mail.com","prof"};
        try {
            stsrv.add(params);
            assertTrue(true);
        } catch (ValidatorException e){
            assertTrue(false);
        }
    }
   
    @Test
    public void addAssignmentTestCase1 (){
        
        ui.vs = vs;
        ui.vt = vt;
        ui.vn = vn;
        
        String[] parametersAddAssignmentValid={"1", "descriere", "6", "4"};
        try {
            tmsrv.add(parametersAddAssignmentValid);
            assertTrue(true);
        } catch (ValidatorException exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addGradeTestCase1 (){
        
        ui.vs = vs;
        ui.vt = vt;
        ui.vn = vn;
    
        String[] parametersAddGradeValid={"1","22","6","4", "feedback", "9"};
        try {
            ntsrv.add(parametersAddGradeValid);
            assertTrue(true);
        } catch (ValidatorException exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addGradeTestCase2 (){
        
        ui.vs = vs;
        ui.vt = vt;
        ui.vn = vn;
    
        String[] parametersAddGradeValid={"1","21","6","4", "feedback", "9"};
        try {
            ntsrv.add(parametersAddGradeValid);
            assertTrue(true);
        } catch (ValidatorException exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addAllTestCase1 (){
        try {
            addStudentTestCase1();
            addAssignmentTestCase1();
            addGradeTestCase1();
            assertTrue(true);
        } catch (Exception exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addAllTestCase2 (){
        try {
            addStudentTestCase1();
            Student s = strepo.findOne("22");
            if (s != null) {
                addAssignmentTestCase1();
                TemaLab t = tmrepo.findOne(1);
                if (t != null) {
                    addGradeTestCase1();
                    assertTrue(true);
                } else {
                    assertFalse(true);
                }
            } else {
                assertFalse(true);
            }
        } catch (Exception exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addAllTestCase3 (){
        try {
            addStudentTestCase1();
            Student s = strepo.findOne("21");
            if (s != null) {
                addAssignmentTestCase1();
                TemaLab t = tmrepo.findOne(1);
                if (t != null) {
                    addGradeTestCase1();
                    assertTrue(true);
                } else {
                    assertFalse(true);
                }
            } else {
                assertTrue(true);
            }
        } catch (Exception exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addAllTestCase4 (){
        try {
            addStudentTestCase1();
            Student s = strepo.findOne("22");
            if (s != null) {
                addAssignmentTestCase1();
                TemaLab t = tmrepo.findOne(2);
                if (t != null) {
                    addGradeTestCase1();
                    assertTrue(true);
                } else {
                    assertTrue(true);
                }
            } else {
                assertFalse(true);
            }
        } catch (Exception exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addAllTestCase5 (){
        try {
            addStudentTestCase1();
            Student s = strepo.findOne("21");
            if (s != null) {
                addAssignmentTestCase1();
                TemaLab t = tmrepo.findOne(1);
                if (t != null) {
                    addGradeTestCase2();
                    assertFalse(false);
                } else {
                    
                    assertTrue(true);
                }
            } else {
                assertFalse(false);
            }
        } catch (Exception exception){ 
            assertFalse(true);
        }

    }
  
}
