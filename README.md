# Banking System - Physical & Logical Data Structures

**Student:** Nikita [Your Full Name]  
**Group:** [Your Group]

## Project Overview
This project implements a complete Mini Banking System that integrates all required data structures:
- **Logical structures**: `LinkedList<BankAccount>` (accounts), `Stack<String>` (transaction history), `Queue` (bill payments and account opening requests)
- **Physical structure**: `BankAccount[3]` array (Task 6)

The system consists of:
- Main menu with Bank / ATM / Admin areas
- Full functionality from Tasks 1–6 in one integrated program

## Features

### 1. Bank Menu
- Submit account opening request (goes to queue)
- Deposit money (updates balance + pushes to Stack)
- Withdraw money (updates balance + pushes to Stack)

### 2. ATM Menu
- Balance enquiry
- Withdraw money

### 3. Admin Area
- View and process account opening queue (FIFO)
- View and process bill payment queue (FIFO)

### 4. Additional Features
- Transaction history with undo (Stack LIFO)
- All operations use the main `LinkedList` for accounts

## Screenshots

### Main Menu
<img width="785" height="709" alt="image" src="https://github.com/user-attachments/assets/89eb0600-9001-4b9a-b084-fbe9fad9dcfb" />

### Bank Menu
<img width="1047" height="871" alt="image" src="https://github.com/user-attachments/assets/e5f386fa-c2ff-4acd-a3e9-02e8f509bff6" />

### ATM Menu
<img width="888" height="807" alt="image" src="https://github.com/user-attachments/assets/98ab841b-8f53-4083-b6b4-37f0dd37472c" />

### Admin Menu
<img width="1033" height="899" alt="image" src="https://github.com/user-attachments/assets/9e093f4d-9d43-4089-984a-f58e0cdc98ed" />

## Work Process Summary
The project was developed step-by-step from individual tasks to a single integrated `BankingSystem.java`.  
All data structures were implemented exactly as specified.  
No external libraries were used.  
The program compiles and runs without errors, handles invalid input gracefully, and fully meets the functionality requirements.

**Repository:** [Add your GitHub link here]

Ready for submission and defense.
