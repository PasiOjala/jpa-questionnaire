package multiChoiseQuestion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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

/**
 *
 * @author t4ojpa00
 */
@Named
@RequestScoped
@Entity
@NamedQueries(
        {
            @NamedQuery(
                    name = "MultiChoiseQuestion.getAll",
                    query = "select mcq from MultiChoiseQuestion mcq"
            )
        }
)
public class MultiChoiseQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String questionText="Question?";
    @OneToMany(fetch=EAGER, cascade=PERSIST)
    private ArrayList<Choise> choises=new ArrayList<>();
    private static int counter=0;
    
    public MultiChoiseQuestion(String questionText, ArrayList<Choise> choises) {
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
    public ArrayList<Choise> getChoisesShuffled() {
        Collections.shuffle(choises);
        return choises;
    }

    public void setChoises(ArrayList<Choise> choises) {
        this.choises = choises;
    }
    
    public void addChoise(Choise choise) {
        this.choises.add(choise);
    }
    public void removeChoise() {
         int idx=new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idx"));
        if (this.choises.size()>1){
        this.choises.remove(idx);
        }
    }
//    public void removeChoise(int idx) {
//        if (this.choises.size()>1 and idx>this.choises.size()-1){
//        this.choises.remove(idx);
//        }
//    }

    public void addChoise() {
        this.choises.add(new Choise());
    }


    public Long getId() {
        return id;
    }
    public MultiChoiseQuestion() {
        this.choises.add(new Choise());
        System.out.println(">>>>>>>>>>>>created"+ ++counter);
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
        if (!(object instanceof MultiChoiseQuestion)) {
            return false;
        }
        MultiChoiseQuestion other = (MultiChoiseQuestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "MultiChoiseQuestion.MultiChoiseQuestion[ id=" + id + " ]";
        String retsrting=this.questionText+"? ";
        
        for (Choise choise : choises) {
            retsrting+=choise.getChoiseText()+":";
            retsrting+=choise.getTrueOrFalse()+" ";
            
        }
        
        return retsrting;
                
    }



    public static void main(String[] args) {
        MultiChoiseQuestion mc=new MultiChoiseQuestion();
        mc.setQuestionText("eka");
        mc.addChoise(new Choise("a",false));
        mc.addChoise(new Choise("b",false));
        mc.addChoise(new Choise("c",true));
        mc.addChoise(new Choise("d",true));
        
        System.out.println(mc.toString());
    }
   
}
