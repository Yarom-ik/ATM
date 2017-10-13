import java.util.Scanner;

public class CashCard  {
    private String lastName;
    private int pinCode;
    private int balance;

    public CashCard(String lastName, int pinCode, int balance){
        this.lastName = lastName;
        this.pinCode = pinCode;
        this.balance = balance;
    }
    public CashCard(String lastName, int pinCode) {
        this(lastName, pinCode, 0);
    }

    public int getBalance(){
        return balance;
    }
    public void  setBalance(int balance){
        this.balance =balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (o == this)
            return true;
        CashCard that = (CashCard) o;
        return this.lastName.equals(that.lastName) && this.pinCode == that.pinCode;
    }

    @Override
    public int hashCode() {
        int result = 17;
        int prime = 31;
        result = result * prime + lastName.hashCode();
        result = result * prime + pinCode;
        return result;
    }
}
