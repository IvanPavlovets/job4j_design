package ru.job4j.solid.lsp.example2;

public class Example2 {

    public class BankingSystem {
        double refinancingRate = 6.5;

        public double getRefinancingRate() {
            return refinancingRate;
        }
    }

    public class Citizens {
        public Double calculateRate(int loanTerm, BankingSystem bankingSystem) {
            Double criditRate = bankingSystem.getRefinancingRate();
            if (loanTerm < 5) {
                criditRate = criditRate * 2;
            } else if (loanTerm < 10) {
                criditRate = criditRate * 1.5;
            } else if (loanTerm < 15) {
                criditRate = criditRate * 1;
            }
            return criditRate;
        }
    }

    /*
     В классе Government ослаблено постусловие.
     Постусловие - условие налагаемое на возвращаемое значение метода.
     */
    public class Government extends Citizens {
        @Override
        public Double calculateRate(int loanTerm, BankingSystem bankingSystem) {
            Double criditRate = bankingSystem.getRefinancingRate() - 1.0;
            return criditRate;
        }
    }

}


