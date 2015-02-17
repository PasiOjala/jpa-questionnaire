package multiChoiseQuestion;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author t4ojpa00
 */
@Named
@Entity
public class multiChoiseQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String questionText="init";
    private ArrayList<Choise> choises=new ArrayList<Choise>();
    
    
    public multiChoiseQuestion(String questionText, ArrayList<Choise> choises) {
        this.questionText = questionText;
        this.choises = choises;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<Choise> getChoises() {
        return choises;
    }

    public void setChoises(ArrayList<Choise> choises) {
        this.choises = choises;
    }
    
    public void addChoises(Choise choise) {
        this.choises.add(choise);
    }


    public Long getId() {
        return id;
    }

    public multiChoiseQuestion() {
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
        if (!(object instanceof multiChoiseQuestion)) {
            return false;
        }
        multiChoiseQuestion other = (multiChoiseQuestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "multiChoiseQuestion.multiChoiseQuestion[ id=" + id + " ]";
        String retsrting=this.questionText+"? ";
        
        for (Choise choise : choises) {
            retsrting+=choise.getChoiseText()+":";
            retsrting+=choise.getTrueOrFalse()+" ";
            
        }
        
        return retsrting;
                
    }



    public static void main(String[] args) {
        multiChoiseQuestion mc=new multiChoiseQuestion();
        mc.setQuestionText("eka");
        mc.addChoises(new Choise("a",false));
        mc.addChoises(new Choise("b",false));
        mc.addChoises(new Choise("c",true));
        mc.addChoises(new Choise("d",true));
        
        System.out.println(mc.toString());
    }
   
}
