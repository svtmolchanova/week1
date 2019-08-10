package clerk;

public enum Customer {

    CUSTOMER_25(0),
    CUSTOMER_50(1),
    CUSTOMER_100(2);

    private int number;

    Customer(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
