package com.techelevator.view;

public class MoneyAccepted {
    enum changeAccepted {
        NICKELS(0.05), DIMES(0.10), QUARTERS(0.25);
        private double coinValue;

        changeAccepted(double coinValue) {
            this.coinValue = coinValue;
        }

        public double getCoinValue() {
            return coinValue;

        }
    }

    enum billsAccepted {
        ONE_DOLLAR(1), TWO_DOLLAR(2), FIVE_DOLLAR(5), TEN_DOLLAR(10), TWENTY_DOLLAR(20);
        private double billValue;
        billsAccepted(double billValue) {
            this.billValue = billValue;
        }
        public double getBillValue() {
            return billValue;
        }
    }
}
