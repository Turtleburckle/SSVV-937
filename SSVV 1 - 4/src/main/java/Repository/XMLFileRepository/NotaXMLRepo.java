package Repository.XMLFileRepository;

import Domain.Nota;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import Validator.NotaValidator;

import java.time.LocalDateTime;


public class NotaXMLRepo extends AbstractXMLRepo<Integer, Nota> {
    //private String fileName;

    public NotaXMLRepo(NotaValidator v, String fileName) {
        super(v,fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document,Nota n) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("nota");
        e.appendChild(createElement("idStudent", document, n.getStudentId()));
        e.appendChild(createElement("idTemaLab", document, Integer.toString(n.getTemaLabId())));
        e.appendChild(createElement("deliveredWeek", document, Integer.toString(n.getDeliveredWeek())));
        e.appendChild(createElement("deadline", document, Integer.toString(n.getDeadline())));
        e.appendChild(createElement("valoare", document, Double.toString(n.getValoare())));
        e.appendChild(createElement("data", document, n.getFeedback()));
        return e;
    }


    @Override
    protected Nota createEntityFromElement(Element notaElement){
        String idStudent=notaElement
                .getElementsByTagName("idStudent")
                .item(0)
                .getTextContent();
        String idTemaLab=notaElement
                .getElementsByTagName("idTemaLab")
                .item(0)
                .getTextContent();
        String dd=notaElement
                .getElementsByTagName("deliveredWeek")
                .item(0)
                .getTextContent();
        String dw=notaElement
                .getElementsByTagName("deadline")
                .item(0)
                .getTextContent();
        String val=notaElement
                .getElementsByTagName("valoare")
                .item(0)
                .getTextContent();
        String data=notaElement
                .getElementsByTagName("feedback")
                .item(0)
                .getTextContent();

        return new Nota(Integer.parseInt(idTemaLab), idStudent, Integer.parseInt(dw), Integer.parseInt(dd),data, Double.parseDouble(val));
    }


}