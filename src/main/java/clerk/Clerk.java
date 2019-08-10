package clerk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clerk {

    public static final int AMOUNT_TICKET = 50;
    public static final ArrayList<Integer> list = new ArrayList<Integer>();

    public boolean checkMoney(Customer customer) {

        if (list.size() == 1 & customer != Customer.CUSTOMER_25) {
            return false;
        } else if (list.get(2) > list.get(1) + list.get(0) ) {
            return false;
        } else if (list.get(1) > list.get(0)) {
            return false;
        } else {
            return true;
        }

    }

    public boolean buyTicket() {

        list.add(0);
        list.add(0);
        list.add(0);
        boolean tryBuy = true;
            for (int i = 0; i < AMOUNT_TICKET && tryBuy == true; i++) {
                int cust = (int)(Math.random() * 3);
                System.out.println(cust);
                Customer customer;
                if (cust == 0) {
                    customer = Customer.CUSTOMER_25;
                } else if (cust == 1) {
                    customer = Customer.CUSTOMER_50;
                } else {
                    customer = Customer.CUSTOMER_100;
                }
                Integer number = (Integer) list.get(customer.getNumber()) + 1;
                list.set(customer.getNumber(), number);
                tryBuy = checkMoney(customer);
            }

        System.out.println(list);
        System.out.println(tryBuy);
        return tryBuy;

    }
}
