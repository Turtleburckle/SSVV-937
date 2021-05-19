package Validator;
import Exceptions.ValidatorException;
import Domain.Student;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId().equals("")){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }
        if(s.getNume().equals("") || s.getNume()==null){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if(s.getEmail().equals("") || s.getEmail()==null){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if (s.getEmail().contains("@") != true || s.getEmail().split("@")[1].contains(".") != true)
        {
            errors+="Email format invalid\n";
        }
        try {
            int id = Integer.parseInt(s.getId());
            if (id < 0) {
                errors += "invalid id";
            }
        } catch (Exception e) {
            errors+="Id invalid\n";
        }

        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}