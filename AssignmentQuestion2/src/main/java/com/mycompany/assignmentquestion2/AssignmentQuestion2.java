/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignmentquestion2;

/**
 *
 * @author lab_services_student
 */
public class AssignmentQuestion2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
//Account super class
class Account{
   protected int accountNumber;   //account number
   protected double balance;       //balance
   //constructor
   public Account(int accountNumber, double balance) {
       this.accountNumber = accountNumber;
       this.balance = balance;
   }
   //deposit function
   public void deposit(double amount) {
       if(amount > 0) {
           balance += amount;
       }
   }
   //withdraw function
   public void withdraw(double amount) {
       if(amount > 0 && amount <= balance) {
           balance -= amount;
       }
   }
   //print function
   public void printDetails() {
       System.out.print(accountNumber + "\t\t" + balance);
   }
}

//Savings account subclass
class Savings extends Account{
   private final double interestRate;   //interest rate
   //constructor
   public Savings(int accountNumber, double balance, double interestRate) {
       super(accountNumber, balance);   //passing arguments to super class
       this.interestRate = interestRate;
   }
   //function to add interest to the balance
   public void addInterest() {
       balance += balance * interestRate / 100.0;
   }
   //function to print details of savings account
   @Override
   public void printDetails() {
       super.printDetails();
       System.out.println("\t\tSavings");
   }
}

//Checking account subclass
class Checking extends Account{
   private final double fee;   //account fee
   //constructor
   public Checking(int accountNumber, double balance, double fee) {
       super(accountNumber, balance);   //passing arguments to super class
       this.fee = fee;
   }
   //function to deduct fee from balance
   public void deductFee() {
       balance -= fee;
   }
   //function to print details of checking account
   @Override
   public void printDetails() {
       super.printDetails();
       System.out.println("\t\tChecking");
   }
}

//driver class
public class BankAccount {
   //main method
   public static void main(String [] args) {
       Account [] accounts = new Account[5];   //an array of 5 accounts
       //initialize 5 different accounts
       accounts[0] = new Savings(12345, 2000.0, 5.0);
       accounts[1] = new Savings(12346, 2500.0, 5.0);
       accounts[2] = new Checking(28949, 1000.0, 10.0);
       accounts[3] = new Savings(28909, 3000.0, 5.0);
       accounts[4] = new Checking(98076, 1500.0, 10.0);
      
       //loop to process interest/fee on each account
       for(int i = 0; i < 5; i++) {
           if(accounts[i].getClass().toString().equals("class Savings")) {
               //add interest to savings account
               ((Savings)accounts[i]).addInterest();
           }
           else {
               //deduct fee for checking account
               ((Checking)accounts[i]).deductFee();
           }
       }
      
       //print details of all accounts to the console
       System.out.println("DETAILS OF ALL ACCOUNTS");
       System.out.println("Account\t\tBalance\t\tType");
       for(int i = 0; i < 5; i++) {   //loop to print the details
           accounts[i].printDetails();
       }
   }
}