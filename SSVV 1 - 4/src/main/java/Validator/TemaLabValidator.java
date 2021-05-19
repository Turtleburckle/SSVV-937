package Validator;
import Exceptions.ValidatorException;
import Domain.TemaLab;
import Validator.IValidator;

public class TemaLabValidator implements IValidator<TemaLab> {

    public void validate(TemaLab t) throws ValidatorException {
        String errors="";
        if(t.getId()== null || t.getId().equals("") || t.getId() <= 0){
            errors += "Nr tema invalid\n";
        }
        if(t.getDescriere()== null || t.getDescriere().equals("")) {
            errors += "Descriere tema invalida\n";
        }
        if(t.getSaptammanaPredarii()<=0 || t.getSaptammanaPredarii()>14) {
            errors += "Sapatamana predarii invalida\n";
        }
        if(t.getTermenLimita()<=0 || t.getTermenLimita()>14) {
            errors += "Termen limita invalid\n";
        }
        if(t.getSaptammanaPredarii() >= t.getTermenLimita()) {
            errors += " invalid time frame";
        }

        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}
