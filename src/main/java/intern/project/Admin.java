package intern.project;

import java.util.Scanner;

public class Admin {
    public static boolean Approval(Scanner scanner, Loan loan) {
        UserRegistration user = new UserRegistration();
        System.out.println("Approve or Reject the loan?");
        System.out.println("Enter 'approve' to approve or 'reject' to reject:");

        String decision = scanner.next().toLowerCase();

        if (decision.equals("approve")) {
            loan.setApproved(true);
            System.out.println("Dear Customer, your loan has been successfully credited to your account at "
                    + user.getBankName() + ". The account number is: "
                    + user.getBankAccountNumber() + ".");

            return true;
        } else if (decision.equals("reject")) {
            loan.setApproved(false);
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'approve' or 'reject'.");
            return Approval(scanner, loan); // Recursive call for re-input
        }
    }
}
