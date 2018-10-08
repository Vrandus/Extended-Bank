package eecs1022.lab5;

/**
 * Created by user on 8/9/18.
 */
import java.util.Arrays;

public class Bank {

    Client[] clients = new Client[6];
    int noc = 0;
    int index = 0;
    String output;
    public Bank(){

    }
    public Bank(String name, String balance) {
        if(noc < 6) {
            if(isDuplicate(name) == false) {
                if(Double.parseDouble(balance) > 0) {
                    clients[noc] = new Client(name, balance);
                    noc++;
                    output = "Client " + name + " Created!";
                }
                else {
                    output = "Error: Non-Positive Initial Balance";
                }
            }
            else {
                output = "Error: Client " + name + " already exists";
            }
        }
        else {
            output = "Error: Maximum Number of Clients Reached";
        }


        //return output;
    }
    public void addClient(String name, String balance){
        if(noc < 6) {
            if(isDuplicate(name) == false) {
                if(Double.parseDouble(balance) > 0) {
                    clients[noc] = new Client(name, balance);
                    noc++;
                    output = "Client " + name + " Created!";
                }
                else {
                    output = "Error: Non-Positive Initial Balance";
                }
            }
            else {
                output = "Error: Client " + name + " already exists";
            }
        }
        else {
            output = "Error: Maximum Number of Clients Reached";
        }
    }


    public boolean isDuplicate(String name) {
        for(int i = 0; i < noc; i++) {
            if(clients[i].name.equals(name)) {
                index = i;
                return true;
            }
        }
        return false;

    }

    public void deposit(String name, String amount) {
        if(isDuplicate(name) == true && Double.parseDouble(amount) > 0) {
            isDuplicate(name);
            clients[index].deposit(Double.parseDouble(amount));
            output = "Transaction Completed";
        }
        else if (isDuplicate(name) == true && Double.parseDouble(amount) <= 0){
            output = "Error: Non-Positive Amount";
        }
        else {
            output = ("Error: " + name + " Does Not Exist");
        }

    }
    public void withdraw(String name, String amount) {
        if(isDuplicate(name) == true && Double.parseDouble(amount) > 0) {
            isDuplicate(name);
            if(clients[index].isSuccessfulWithdraw(Double.parseDouble((amount))) == true)
            {
                clients[index].withdraw(Double.parseDouble(amount));
                output = "Transaction Completed";
            }
            else{
                output = "Error: Amount too large to withdraw";
            }
        }
        else if(isDuplicate(name) == true && Double.parseDouble(amount) < 0){
            output = "Error: Non-Positive Amount";
        }
        else {
            output = ("Error: " + name + " Does Not Exist");
        }

    }
    public void transfer(String fromClient, String toClient, String amount) {
        if(isDuplicate(fromClient) == true && isDuplicate(toClient) == true) {
            isDuplicate(fromClient);
            if(clients[index].isSuccessfulWithdraw(Double.parseDouble((amount))) == true) {
                deposit(toClient, amount);
                withdraw(fromClient, amount);
                output = "Transaction Completed";
            }
            else{
                output = "Error: Amount too large to withdraw";
            }
        }
        if(isDuplicate(fromClient) == false) {
            output = ("Error: " + fromClient + " Does Not Exist");
            if(isDuplicate(toClient) == false) {
                output += ("Error: " + toClient + " Does Not Exist");
            }
        }
        else if(isDuplicate(toClient) == false) {
            output = ("Error: " + toClient + " Does Not Exist");
        }

    }
    public void completeTransaction(String service, String toClient, String fromClient, String amount) {
        if(service.equalsIgnoreCase("deposit")) {
            deposit(toClient, amount);
        }
        if(service.equalsIgnoreCase("withdraw")) {
            withdraw(fromClient, amount);
        }
        if(service.equalsIgnoreCase("transfer")) {
            transfer(fromClient, toClient, amount);
        }
    }
    public void outputStatement(String name){
        if(isDuplicate(name)==true){
            isDuplicate(name);
            output = clients[index].toString();
        }
        else {
            output = "Error: " + name + " Does Not Exist";
        }
    }
    public String toString(String name){
        return output;
    }

}