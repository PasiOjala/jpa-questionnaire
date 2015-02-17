/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiChoiseQuestion;

/**
 *
 * @author t4ojpa00
 */
    public class Choise {

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

    }