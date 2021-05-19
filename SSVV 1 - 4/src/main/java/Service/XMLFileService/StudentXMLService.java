package Service.XMLFileService;

import Domain.Student;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import UI.ui;

public class StudentXMLService extends AbstractXMLService<String,Student>{
    private StudentXMLRepo xmlrepo;

    public StudentXMLService(StudentXMLRepo xmlrepo)  {
        super(xmlrepo);
        this.xmlrepo = xmlrepo;
    }

    @Override
    protected Student extractEntity(String[] params){
        int grupa=0;
        try{
            grupa=Integer.parseInt(params[2]);
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        return new Student(params[0],params[1],grupa,params[3],params[4]);
    }

    @Override
    public void add(String[] params) throws ValidatorException {
        Student e=extractEntity(params);
        ui.vs.validate(e);
        xmlrepo.save(e);
        System.out.println("the student was added");
    }

}