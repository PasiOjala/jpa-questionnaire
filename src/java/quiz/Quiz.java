/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import multiChoiseQuestion.MultiChoiseQuestion;

/**
 *
 * @author Pasi
 */
@Named
@RequestScoped
@Entity
@NamedQueries(
        {
            @NamedQuery(
                    name = "Quiz.getAll",
                    query = "select quizz from Quiz quizz"
            )
        }
)
public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch=EAGER, cascade=PERSIST)
    private ArrayList<multiChoiseQuestion.MultiChoiseQuestion> questionList=new ArrayList<>();
    private String quizName="default quiz name";

    public ArrayList<MultiChoiseQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<MultiChoiseQuestion> questionList) {
        this.questionList = questionList;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
    
    public void addMCQ(MultiChoiseQuestion mcq){
        questionList.add(mcq);
    }
    
        public void removeMCQ() {
         int idx=new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idx"));
        this.questionList.remove(idx);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quiz.Quiz[ id=" + id + " ]";
    }
    
}
