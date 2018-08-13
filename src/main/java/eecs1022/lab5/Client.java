package eecs1022.lab5;

/**
 * Created by user on 8/9/18.
 */
public class Client {
    public Client(String name, String balance) {
        this.name = name;
        this.balance = Double.parseDouble(balance);
    }



    String name;
    double balance;
    String output = "";
    Transaction[] history = new Transaction[10];
    int not = 0;
    public void withdraw(double amount) {
        if(amount > 0) {
            if( balance - amount >= 0) {
                balance -= amount;
                history[not] = new Transaction("WITHDRAW", amount);
               // history[not].type = "WITHDRAW";
               // history[not].amount = amount;
                not++;
            }

            else {
                System.out.println("Error: Amount too large to withdraw.");
            }
        }
        else {
            System.out.println("Error: Non-Positive Amount");
        }
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            history[not] = new Transaction("DEPOSIT", amount);
            //history[not].type = "DEPOSIT";
            //history[not].amount = amount;
            not++;
        }
        else {
            System.out.println("Error: Non-Positive Amount");
        }
    }
    public boolean isSuccessfulWithdraw(double amount) {
        if(balance - amount > 0) {
            return true;
        }

        return false;
    }
    public String toString(){
        output = "Statement of Client " + name + "(balance is $" + balance + ")";
        for(int i = 0; i < not; i++){
            output += "\n" + history[i].toString();
        }
        return output;
    }


}

