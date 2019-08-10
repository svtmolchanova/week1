package supermarket;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Semaphore;

public class Supermarket {

    private static final int AMOUNT_CASH_REGISTER = 3;

    private static final boolean[] CASH_REGISTER = new boolean[AMOUNT_CASH_REGISTER];

    private static final Semaphore SEMAPHORE = new Semaphore(AMOUNT_CASH_REGISTER, true);

    private static final ArrayList<Integer> time = new ArrayList<Integer>();

    public void totalTime () throws InterruptedException{

        this.startCashRegister();

        int max = time.get(0);
        for(int i = 0; i < time.size(); i ++){
            if(time.get(i) > max){
                max = time.get(i);
            }
        }
        System.out.println(time);
        System.out.println("totalTime = " + max);


    }

    public void startCashRegister () throws InterruptedException{

        int amountCustomer = 1 + (int)(Math.random()*10);
        System.out.println("количество покупателей " + amountCustomer);

        for (int i = 1; i <= amountCustomer; i++) {
            new Thread(new CashRegister(i)).start();
            Thread.sleep(2);
        }

    }



    public static class CashRegister implements Runnable {

        private int customer;
        private int amountPurchase;

        public CashRegister(int customer) {
            this.customer = customer;

        }



        @Override
        public void run() {

            int amountBuy = 1 + (int)(Math.random()*10);
            System.out.println("количество покупок у покупателя " + customer + " = " + amountBuy);


            try {
                SEMAPHORE.acquire();
                int register = -1;

                synchronized (CASH_REGISTER) {
                    for (int i = 0; i < AMOUNT_CASH_REGISTER; i++)
                        if (!CASH_REGISTER[i]) {
                            CASH_REGISTER[i] = true;
                            register = i;
                            if (time.size()-1 < i) {
                                time.add(i, 0);
                            }
                            int indexTime = Objects.isNull(time.get(i)) ? 0 : time.get(i) + amountBuy;
                            time.add(i, indexTime);
                            System.out.println("Покупатель " + customer + " подошел к кассе " + (i+1));
                            break;
                        }

                }


                Thread.sleep(amountBuy);

                synchronized (CASH_REGISTER) {
                    CASH_REGISTER[register] = false;
                }

                SEMAPHORE.release();

            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
