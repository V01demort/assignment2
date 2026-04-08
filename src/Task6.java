public class Task6 {
    static class BankAccount {
        String accountNumber;
        String username;
        int balance;

        public BankAccount(String accountNumber, String username, int balance) {
            this.accountNumber = accountNumber;
            this.username = username;
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount("ACC001", "Ali", 150000);
        accounts[1] = new BankAccount("ACC002", "Sara", 220000);
        accounts[2] = new BankAccount("ACC003", "Omar", 100000);

        System.out.println("=== TASK 6: Physical Data Structures (Array) ===");
        System.out.println("Predefined accounts in Array:");
        for (int i = 0; i < accounts.length; i++) {
            System.out.println((i + 1) + ". " + accounts[i].username +
                    " – Balance: " + accounts[i].balance);
        }
    }
}