/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiChoiseQuestion;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Named
@RequestScoped
@Entity
    public class Choise implements Serializable {
      private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


        private String choiseText = "def";
        private boolean trueOrFalse = false;

        public Choise() {
        }

        public Choise(String choiseText, boolean trueOrFalse) {
            this.choiseText = choiseText;
            this.trueOrFalse = trueOrFalse;

        }

        public String getChoiseText() {
            return choiseText;
        }

        public void setChoiseText(String choiseText) {
            this.choiseText = choiseText;
        }

        public boolean getTrueOrFalse() {
            return trueOrFalse;
        }

        public void setTrueOrFalse(boolean trueOrFalse) {
            this.trueOrFalse = trueOrFalse;
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
        Choise other = (Choise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Choise.Choise[ id=" + id + " ]";
 
                
    }
    }