import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        CashCard card1 = new CashCard ("Sidorov", 1111, 800 );
        CashCard card2 = new CashCard ("Admin", 6969, 0 );
        CashCard card3 = new CashCard ("Ivanov", 1212, 200 );

        Set<CashCard> cashCards = new HashSet<CashCard>();
        cashCards.add(card1);
        cashCards.add(card2);
        cashCards.add(card3);

        Atm atm = new Atm(cashCards);
        atm.Banknotes();
        atm.run();

    }
}
