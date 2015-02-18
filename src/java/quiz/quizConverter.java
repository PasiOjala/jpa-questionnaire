/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.util.ArrayList;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import multiChoiseQuestion.MultiCQHandler;
import multiChoiseQuestion.MultiChoiseQuestion;
import multiChoiseQuestion.Choise;

/**
 *
 * @author Pasi
 */
@FacesConverter("quiz.quizConverter")
public class quizConverter implements Converter {
@Inject
MultiCQHandler mcqh;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for (MultiChoiseQuestion mcq: mcqh.getAllQA()){
            if (value.contains(mcq.getQuestionText()))
            {
                ArrayList<multiChoiseQuestion.Choise> choises=mcq.getChoises();
                for (multiChoiseQuestion.Choise c:choises){
                    if (!value.contains(c.getChoiseText())){
                        break;
                    }
                    return mcq;
                }
            }
        }
//        return value;
        throw new UnsupportedOperationException("FAILED"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return value.toString();
    }
    
}
