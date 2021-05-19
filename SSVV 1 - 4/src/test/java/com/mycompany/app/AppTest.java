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

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addStudentTestCase1()
    {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        ui.vs = vs;
        ui.vt = vt;
        ui.vn = vn;
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        String[] params={"22","nume1","1","email@mail.com","prof"};
        try {
            stsrv.add(params);
            assertTrue(true);
        } catch (ValidatorException e){
            assertTrue(false);
        }
    }
    @Test
    public void addStudentTestCase2()
    {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        ui.vs = vs;
        ui.vt = vt;
        ui.vn = vn;
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        String[] params={"22","nume1","grupa1","email@mail.com","prof"};
        try {
            stsrv.add(params);
            assertFalse(true);
        } catch (ValidatorException e){
            assertFalse(false);
        }
    }

    @Test
    public void test(){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);

        // Empty ID
        String[] parametersEmptyID={"","nume1","1","email@mail.com","prof"};
        String expectedMessageEmptyID = "Id invalid";
        try {
            studentService.add(parametersEmptyID);
            fail();
        } catch (ValidatorException exception){ assertTrue(exception.getMessage().contains(expectedMessageEmptyID));}

        // Not int ID
        String[] parametersNotInt={"id","nume1","1","email@mail.com","prof"};
        try {
            studentService.add(parametersNotInt);
            fail();
        } catch (ValidatorException exception){ assertFalse(false);}

        // Less than 0 ID
        String[] parametersLessThanZeroID={"-1","nume1","grupa1","email@mail.com","prof"};
        String expectedMessageLessThanZeroID = "invalid id";
        try {
            studentService.add(parametersLessThanZeroID);
            System.out.println("passed");
            assertFalse(true);
        } catch (ValidatorException exception){ 
            
            assertTrue(true);}
    }
    /**
     * Incorrect IDs. An ID is incorrect if:
     * 1. it's empty;
     * 2. it's not an int;
     * 3. it's less than 0;
     */
    @Test
    public void addStudentTestCase3(){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);

        // Empty ID
        String[] parametersEmptyID={"","nume1","1","email@mail.com","prof"};
        String expectedMessageEmptyID = "Id invalid";
        try {
            studentService.add(parametersEmptyID);
            fail();
        } catch (ValidatorException exception){ assertTrue(exception.getMessage().contains(expectedMessageEmptyID));}

        // Not int ID
        String[] parametersNotInt={"id","nume1","1","email@mail.com","prof"};
        try {
            studentService.add(parametersNotInt);
            fail();
        } catch (ValidatorException exception){ assertFalse(false);}

        // Less than 0 ID
        String[] parametersLessThanZeroID={"-1","nume1","grupa1","email@mail.com","prof"};
        String expectedMessageLessThanZeroID = "invalid id";
        try {
            studentService.add(parametersLessThanZeroID);
            fail();
        } catch (ValidatorException exception){ assertTrue(exception.getMessage().contains(expectedMessageLessThanZeroID));}
    }

    /**
     * Incorrect Name. A name is incorrect if the input is empty.
     */
    @Test
    public void addStudentTestCase4(){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);

        // Empty Name
        String[] parametersEmptyName={"4","","1","email@mail.com","prof"};
        String expectedMessageEmptyName = "Nume invalid";
        try {
            studentService.add(parametersEmptyName);
            fail();
        } catch (ValidatorException exception){ assertTrue(exception.getMessage().contains(expectedMessageEmptyName));}
    }

    /**
     * Incorrect Email. An email is incorrect if:
     * 1. it's empty;
     * 2. it's not containing "@";
     * 3. it's not containing "." after "@";
     */
    @Test
    public void addStudentTestCase5(){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);

        // Empty email
        String[] parametersEmptyEmail={"4","Name1","1","","prof"};
        String expectedMessageEmptyEmail = "Email invalid";
        try {
            studentService.add(parametersEmptyEmail);
            fail();
        } catch (ValidatorException exception){ assertTrue(exception.getMessage().contains(expectedMessageEmptyEmail));}

        // Missing "@"
        String[] parametersMissingA={"4","Name1","1","emailMail.com","prof"};
        String expectedMessageMissingA = "Email format invalid";
        try {
            studentService.add(parametersMissingA);
            fail();
        } catch (ValidatorException exception){ assertTrue(exception.getMessage().contains(expectedMessageMissingA));}

        // Missing "." after "@"
        String[] parametersMissingPeriod={"4","Name1","1","email@mailCom","prof"};
        String expectedMessageMissingPeriod = "Email format invalid";
        try {
            studentService.add(parametersMissingPeriod);
            fail();
        } catch (ValidatorException exception){ assertTrue(exception.getMessage().contains(expectedMessageMissingPeriod));}
    }

    @Test
    public void addAssignmentTestCase1 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentValid={"1", "descriere", "6", "4"};
        try {
            homeworkService.add(parametersAddAssignmentValid);
            assertTrue(true);
        } catch (ValidatorException exception){ 
            assertFalse(true);
        }

    }
    @Test
    public void addAssignmentTestCase2 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "descriere", "3", "4"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (ValidatorException exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase3 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"0", "descriere", "5", "4"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase4 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "", "5", "4"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase5 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "descriere", "", "4"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase6 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "descriere", "15", "4"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase7 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "descriere", "vb", "4"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase8 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "descriere", "3", "15"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase9 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "descriere", "3", ""};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
    @Test
    public void addAssignmentTestCase10 (){
        StudentValidator studentValidator=new StudentValidator();
        TemaLabValidator homeworkValidator=new TemaLabValidator();
        NotaValidator gradeValidator=new NotaValidator();
        ui.vs = studentValidator;
        ui.vt = homeworkValidator;
        ui.vn = gradeValidator;
        StudentXMLRepo studentRepository=new StudentXMLRepo(studentValidator,"StudentiXML.xml");
        TemaLabXMLRepo homeworkRepository=new TemaLabXMLRepo(homeworkValidator,"TemaLaboratorXML.xml");
        NotaXMLRepo gradeRepository=new NotaXMLRepo(gradeValidator,"NotaXML.xml");
        StudentXMLService studentService=new StudentXMLService(studentRepository);
        TemaLabXMLService homeworkService=new TemaLabXMLService(homeworkRepository);
        NotaXMLService gradeService=new NotaXMLService(gradeRepository);
        String[] parametersAddAssignmentInvalid={"1", "descriere", "3", "hj"};
        try {
            homeworkService.add(parametersAddAssignmentInvalid);
            assertFalse(true);
        } catch (Exception exception){ 
            assertFalse(false);
        }

    }
}
