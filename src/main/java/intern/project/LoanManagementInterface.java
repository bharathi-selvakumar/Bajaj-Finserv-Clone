package intern.project;

import java.util.Scanner;

public interface LoanManagementInterface {
    void applyForLoan(Scanner scanner, String username);
    void viewLoanStatus(Scanner scanner,String username);
    void viewPastLoanRepaymentHistory(Scanner scanner,String username);
    void repayLoan(Scanner scanner, String username);
    void updateProfile(Scanner scanner, String username);
} 
