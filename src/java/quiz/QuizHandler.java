/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pasi
 */
@Named
@Stateless
public class QuizHandler {
        @PersistenceContext
    EntityManager em;
    
    private  Quiz newQuiz=new Quiz();
    private ArrayList<Quiz>allQuestions= new ArrayList<>();

    public Quiz getNewQuiz() {
        return newQuiz;
    }

    public void resetNewQuiz() {
        newQuiz=new Quiz();
    }

    public ArrayList<Quiz> getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(ArrayList<Quiz> allQuestions) {
        this.allQuestions = allQuestions;
    }
    public void addQ(){
        em.persist(newQuiz);
        allQuestions.add(newQuiz);
        
    }
    
    @Produces @Named("allQ")
    public List <Quiz> getAllQ(){
        List <Quiz> ret=em.createNamedQuery("Quiz.getAll",
                                Quiz.class).getResultList();
        return ret;
    }

    
}
