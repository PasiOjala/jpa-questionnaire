/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiChoiseQuestion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author t4ojpa00
 */

@Named
@Stateless
public class MultiCQHandler implements Serializable{
    
    @PersistenceContext
    EntityManager em;
    
    private  MultiChoiseQuestion newMCQ=new MultiChoiseQuestion();
    private ArrayList<MultiChoiseQuestion>allQuestionsAndAnswers= new ArrayList<>();

    public MultiChoiseQuestion getNewMCQ() {
        return newMCQ;
    }

    public void resetNewMCQ() {
        newMCQ=new MultiChoiseQuestion();
    }

    public ArrayList<MultiChoiseQuestion> getAllQuestionsAndAnswers() {
        return allQuestionsAndAnswers;
    }

    public void setAllQuestionsAndAnswers(ArrayList<MultiChoiseQuestion> allQuestionsAndAnswers) {
        this.allQuestionsAndAnswers = allQuestionsAndAnswers;
    }
    public void addQA(){
        em.persist(newMCQ);
        allQuestionsAndAnswers.add(newMCQ);
        
    }
    
    @Produces @Named("allQA")
    public List <MultiChoiseQuestion> getAllQA(){
        List <MultiChoiseQuestion> ret=em.createNamedQuery("MultiChoiseQuestion.getAll",
                                MultiChoiseQuestion.class).getResultList();
        return ret;
    }
    
}
