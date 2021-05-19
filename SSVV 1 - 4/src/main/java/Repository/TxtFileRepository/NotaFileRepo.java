package Repository.TxtFileRepository;

import Domain.HasId;
import Domain.Nota;
import Validator.NotaValidator;

import java.io.*;
import java.time.LocalDateTime;

public class NotaFileRepo extends AbstractFileRepository {
    public NotaFileRepo(String filename, NotaValidator val) throws IOException {
        super(val, filename);
    }

    @Override
    public HasId extractEntity(String[] info) {
        Integer idTema = Integer.parseInt(info[0]);
        String idStudent = info[1];
        Integer dw = Integer.parseInt(info[2]);
        Integer dd = Integer.parseInt(info[3]);
        double valoare = Double.parseDouble(info[5]);
        //TemaLab t=findOne(idTema);
        String ldt=info[4];
        Nota n = new Nota( idTema, idStudent, dw, dd, ldt,valoare);
        return n;
    }


}