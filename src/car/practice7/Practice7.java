package car.practice7;

import java.util.Scanner;

public class Practice7 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        CashCard card1 = new CashCard("A001", 500, 0);
        card1.store(console.nextInt());

        CashCard card2 = new CashCard("A002", 300, 0);
        card2.store(console.nextInt());

        CashCard card3 = new CashCard("A003", 1000, 1);
        card3.store(console.nextInt());

        System.out.printf("明細 (%s, %d, %d)%n",
                card1.getNumber(), card1.getBalance(), card1.getBonus());
        System.out.printf("明細 (%s, %d, %d)%n",
                card2.getNumber(), card2.getBalance(), card2.getBonus());
        System.out.printf("明細 (%s, %d, %d)%n",
                card3.getNumber(), card3.getBalance(), card3.getBonus());
    }
}
class CashCard {
    private String number;
    private int balance;
    private int bonus;
    private IllegalArgumentException ex;

    CashCard(String number, int balance, int bonus) throws IllegalArgumentException{
        this.number = number;
        this.balance = balance;
        this.bonus = bonus;
    }

    void store(int money) {
        if(money > 0) {
            this.balance += money;
            if(money >= 1000) {
                this.bonus++;
            }
        }
        else {
            System.out.println("儲值是負的？你是來亂的嗎？");
            throw ex;
        }
    }

    void charge(int money) {
        if(money > 0) {
            if(money <= this.balance) {
                this.balance -= money;
            }
            else {
                System.out.println("錢不夠啦！");
            }
        }
        else {
            System.out.println("扣負數？這不是叫我儲值嗎？");
            throw ex;
        }
    }

    int exchange(int bonus) {
        if(bonus > 0) {
            this.bonus -= bonus;
        }
        return this.bonus;
    }

    int getBalance() {
        return balance;
    }

    int getBonus() {
        return bonus;
    }

    String getNumber() {
        return number;
    }
}
