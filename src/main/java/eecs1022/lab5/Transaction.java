package eecs1022.lab5;

/**
 * Created by user on 8/9/18.
 */
public class Transaction {
    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
    }
    String type;
    double amount;
    public String toString(){
        return "TRANSACTION " + type + ": " + amount;
    }

}