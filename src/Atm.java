import java.util.Scanner;
import java.util.Set;

public class Atm {
    private Set<CashCard> cashCards;
    private int[][] arrayMoney;

    int j = 0;
    int i = 0;
    public Atm(Set<CashCard> cashCards) {
        this.cashCards = cashCards;
    }

    public void setCashCards(Set<CashCard> cashCards) {
        this.cashCards = cashCards;
    }

    public void Banknotes() {
        arrayMoney = new int[3][2];
        arrayMoney[0][0] = 5;
        arrayMoney[1][0] = 10;
        arrayMoney[2][0] = 20;
        arrayMoney[0][1] = 10;
        arrayMoney[1][1] = 4;
        arrayMoney[2][1] = 8;
    }

    public void run() {
        do {
            try {
                System.out.println("Вставте карту");
                Scanner inputCardScanner = new Scanner(System.in);

                String inputCard = inputCardScanner.nextLine();

                System.out.println("Введите фамилию");
                String lastName = inputCardScanner.nextLine();

                System.out.println("Введите pinCod");
                int pinCode = inputCardScanner.nextInt();

                CashCard cashCardToCheck = new CashCard(lastName, pinCode, 0);

                if (!cashCards.contains(cashCardToCheck)) {
                    System.out.println("Неправильно введена фамилия или пинкод!");
                    continue;
                } else {
                    do {
                        if (lastName.equals("Admin") && (pinCode == 6969)) {
                            System.out.println("Купюры в банкомате:");
                            for (int i = 0; i < arrayMoney.length; i++) {
                                for (int j = 0; j < arrayMoney[i].length; j++) {
                                    System.out.print(arrayMoney[i][j] + "\t");
                                }
                                System.out.println();
                            }
                            System.out.println("Введите 1 для добавления или 0 для выхода");
                            int moneyAmount = inputCardScanner.nextInt();
                            if (moneyAmount == 0)
                                break;
                            System.out.println("Введите количество купюр согласно номиналу");
                            for (i = 0, j = 0; i < arrayMoney.length; i++) {
                                System.out.print(arrayMoney[i][j] + " руб - ");
                                arrayMoney[i][j + 1] += inputCardScanner.nextInt();
                            }
                            break;
                        }

                        System.out.println("Введите сумму для снятия или 0 для выхода");
                        int moneyAmount = inputCardScanner.nextInt();
                        if (moneyAmount == 0)
                            break;

                        for (CashCard cashCard : cashCards) {
                            if (cashCard.equals(cashCardToCheck)) {
                                System.out.println("На вашем счету " + cashCard.getBalance() + " руб");
                                j = 0;
                                i = 2;
                                int balance = cashCard.getBalance();
                                int[][] bufArrayMoney;
                                bufArrayMoney = arrayMoney.clone();
                                for (i = 0; i < bufArrayMoney.length; i++)
                                    bufArrayMoney[i] = arrayMoney[i].clone();
                                int bufBalance = balance;
                                if (balance >= moneyAmount) {
                                    if (moneyAmount < 5) {
                                        System.out.println("Неправильно введена сумма");
                                        break;
                                    }

                                    for (i = 2; i >= 0; i--) {
                                        while (moneyAmount >= arrayMoney[i][j] && arrayMoney[i][j + 1] > 0) {
                                            if (moneyAmount >= arrayMoney[i][j]) {
                                                balance = balance - arrayMoney[i][j];
                                                moneyAmount = moneyAmount - arrayMoney[i][j];
                                                arrayMoney[i][j + 1] = arrayMoney[i][j + 1] - 1;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Введенная сумма больше балланса");
                                    break;
                                }
                                if (moneyAmount == 0) {
                                    System.out.println("Купюры для выдачи:");
                                    for (j = 0, i = 0; i < arrayMoney.length; i++) {
                                        System.out.println(arrayMoney[i][j] + " руб " + (bufArrayMoney[i][j + 1] - arrayMoney[i][j + 1])+" шт.");
                                    }
                                    cashCard.setBalance(balance);
                                    System.out.println("На вашем счету осталось " + cashCard.getBalance() + " руб");
                                } else {
                                    arrayMoney = bufArrayMoney.clone();
                                    for (i = 0; i < arrayMoney.length; i++)
                                        arrayMoney[i] = bufArrayMoney[i].clone();
                                    cashCard.setBalance(bufBalance);
                                    System.out.println("Ошибка выдачи купюр (нет купюр)");
                                }
                            }
                        }

                    }
                    while (true);
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } while (true);
    }

}

