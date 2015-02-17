/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiChoiseQuestion;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author t4ojpa00
 */
public class MultiQAs {
    
    @PersistenceContext
    EntityManager em;
    
    private ArrayList<multiChoiseQuestion>allQuestionsAndAnswers= new ArrayList<>();

    public ArrayList<multiChoiseQuestion> getAllQuestionsAndAnswers() {
        return allQuestionsAndAnswers;
    }

    public void setAllQuestionsAndAnswers(ArrayList<multiChoiseQuestion> allQuestionsAndAnswers) {
        this.allQuestionsAndAnswers = allQuestionsAndAnswers;
    }
    public void addQA(multiChoiseQuestion mcq){
        em.persist(mcq);
        allQuestionsAndAnswers.add(mcq);
        
    }
    
}
