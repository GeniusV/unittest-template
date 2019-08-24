package com.geniusver.hello.unittest;

/**
 * Created by GeniusV on 2019-08-11.
 */
public class User {
    private String username;
    private String password;
    private int age;

    private Wallet wallet;


    @Override
    public String toString() {
        return "com.geniusver.hello.unittest.User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", wallet=" + wallet.getBalance() +
                '}';
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return this.wallet.getBalance();
    }

    private int getPrivateMoney() {
        return 100;
    }

    public int getTotalMoney() {
        return getPrivateMoney() + wallet.getBalance();
    }


     class Wallet {
        private int balance;

        public int getBalance() {
            return balance;
        }

         public int getBalance(Object object) {
             return balance;
         }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}

