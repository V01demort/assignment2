import java.util.*;

public class BankingSystem {
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
        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> transactionHistory = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<BankAccount> accountRequests = new LinkedList<>();

        accounts.add(new BankAccount("ACC001", "Ali", 150000));
        accounts.add(new BankAccount("ACC002", "Sara", 220000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1 – Enter Bank");
            System.out.println("2 – Enter ATM");
            System.out.println("3 – Admin Area");
            System.out.println("4 – Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                while (true) {
                    System.out.println("\n=== BANK MENU ===");
                    System.out.println("1. Submit account opening request");
                    System.out.println("2. Deposit money");
                    System.out.println("3. Withdraw money");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("Choose: ");
                    int b = scanner.nextInt();
                    scanner.nextLine();

                    if (b == 1) {
                        System.out.print("Enter account number: ");
                        String num = scanner.nextLine();
                        System.out.print("Enter username: ");
                        String user = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        int bal = scanner.nextInt();
                        scanner.nextLine();
                        accountRequests.offer(new BankAccount(num, user, bal));
                        System.out.println("Request submitted successfully");

                    } else if (b == 2) {
                        depositOrWithdraw(accounts, transactionHistory, scanner, true);

                    } else if (b == 3) {
                        depositOrWithdraw(accounts, transactionHistory, scanner, false);

                    } else if (b == 4) break;
                    else System.out.println("Invalid option!");
                }

            } else if (choice == 2) {
                while (true) {
                    System.out.println("\n=== ATM MENU ===");
                    System.out.println("1. Balance enquiry");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Back to Main Menu");
                    System.out.print("Choose: ");
                    int a = scanner.nextInt();
                    scanner.nextLine();

                    if (a == 1) {
                        System.out.print("Enter username: ");
                        String user = scanner.nextLine();
                        BankAccount acc = findAccount(accounts, user);
                        if (acc != null) {
                            System.out.println("Balance for " + user + ": " + acc.balance);
                        } else {
                            System.out.println("Account not found.");
                        }

                    } else if (a == 2) {
                        depositOrWithdraw(accounts, transactionHistory, scanner, false);

                    } else if (a == 3) break;
                    else System.out.println("Invalid option!");
                }

            } else if (choice == 3) {
                while (true) {
                    System.out.println("\n=== ADMIN AREA ===");
                    System.out.println("1. View pending account requests");
                    System.out.println("2. Process next account request");
                    System.out.println("3. View bill queue");
                    System.out.println("4. Process next bill payment");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Choose: ");
                    int ad = scanner.nextInt();
                    scanner.nextLine();

                    if (ad == 1) {
                        System.out.println("Pending Account Requests:");
                        if (accountRequests.isEmpty()) {
                            System.out.println("No pending requests.");
                        } else {
                            int i = 1;
                            for (BankAccount req : accountRequests) {
                                System.out.println(i + ". " + req.username + " | " + req.accountNumber + " | " + req.balance);
                                i++;
                            }
                        }

                    } else if (ad == 2) {
                        if (accountRequests.isEmpty()) {
                            System.out.println("No pending requests.");
                        } else {
                            BankAccount req = accountRequests.poll();
                            accounts.add(req);
                            System.out.println("Account processed: " + req.username + " added to main list");
                        }

                    } else if (ad == 3) {
                        System.out.println("Bill Queue:");
                        if (billQueue.isEmpty()) {
                            System.out.println("Queue is empty.");
                        } else {
                            for (String bill : billQueue) {
                                System.out.println(bill);
                            }
                        }

                    } else if (ad == 4) {
                        if (billQueue.isEmpty()) {
                            System.out.println("No bills in queue.");
                        } else {
                            String bill = billQueue.poll();
                            System.out.println("Processing: " + bill);
                            if (!billQueue.isEmpty()) {
                                System.out.println("Remaining: " + billQueue.peek());
                            }
                        }

                    } else if (ad == 5) break;
                    else System.out.println("Invalid option!");
                }

            } else if (choice == 4) {
                System.out.println("Thank you! Goodbye.");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }

    private static void depositOrWithdraw(LinkedList<BankAccount> accounts,
                                          Stack<String> history,
                                          Scanner scanner,
                                          boolean isDeposit) {
        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        BankAccount acc = findAccount(accounts, user);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print(isDeposit ? "Deposit amount: " : "Withdraw amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        if (isDeposit) {
            acc.balance += amount;
            String trans = "Deposit " + amount + " to " + user;
            history.push(trans);
            System.out.println(trans);
            System.out.println("New balance: " + acc.balance);
        } else {
            if (amount > acc.balance) {
                System.out.println("Insufficient balance!");
            } else {
                acc.balance -= amount;
                String trans = "Withdraw " + amount + " from " + user;
                history.push(trans);
                System.out.println(trans);
                System.out.println("New balance: " + acc.balance);
            }
        }
    }

    private static BankAccount findAccount(LinkedList<BankAccount> accounts, String username) {
        for (BankAccount acc : accounts) {
            if (acc.username.equals(username)) {
                return acc;
            }
        }
        return null;
    }
}