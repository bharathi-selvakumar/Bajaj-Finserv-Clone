package intern.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserRegistrationData implements LoanManagementInterface {
    private static HashMap<String, UserRegistration> userData = new HashMap<>();

    public static void addPredefinedUsers() {
        UserRegistration user1 = new UserRegistration();
        user1.setFullName("Bharathi");
        user1.setUsername("EJ");
        user1.setPassword("password123");
        user1.setMobileNumber("1234567890");
        user1.setEmailAddress("john_doe@example.com");
        user1.setAadhaarNumber("123412341234");
        user1.setPanNumber("ABCDE1234F");
        user1.setOccupationType("Salaried");
        user1.setMonthlyIncome(50000);
        user1.setBankAccountNumber("123456789012");
        user1.setBankName("State Bank of India");
        user1.setBankIFSCCode("SBIN0001234");

        UserRegistration user2 = new UserRegistration();
        user2.setFullName("Lokesh");
        user2.setUsername("JD");
        user2.setPassword("password123");
        user2.setMobileNumber("9876543210");
        user2.setEmailAddress("jane_smith@example.com");
        user2.setAadhaarNumber("432143214321");
        user2.setPanNumber("ABCDE4321G");
        user2.setOccupationType("Self-Employed");
        user2.setMonthlyIncome(75000);
        user2.setBankAccountNumber("987654321098");
        user2.setBankName("HDFC Bank");
        user2.setBankIFSCCode("HDFC0009876");

        userData.put(user1.getUsername(), user1);
        userData.put(user2.getUsername(), user2);
    }

    public static void Choice() {
        System.out.println("Welcome to Bajaj Finserv!");
        System.out.println("Login:");
        login();
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (validateLogin(username, password)) {
            System.out.println("Login successful! Welcome, " + username);
            UserRegistrationData userRegistrationData = new UserRegistrationData();
            userRegistrationData.showUserMenu(scanner, username);
        } else {
            System.out.println("Invalid username or password. Please try again.");
            Choice();
        }
    }

    private static boolean validateLogin(String username, String password) {
        UserRegistration user = userData.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void showUserMenu(Scanner scanner, String username) {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Apply for a Loan");
        System.out.println("2. View Loan Status");
        System.out.println("3. View Past Loan Repayment History");
        System.out.println("4. Repay Loan");
        System.out.println("5. Update Profile");
        System.out.println("6. Logout");
    
        System.out.print("Choose an option (1-6): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        switch (choice) {
            case 1:
                applyForLoan(scanner, username);
                break;
            case 2:
                viewLoanStatus(scanner, username);
                break;
            case 3:
                viewPastLoanRepaymentHistory(scanner, username);
                break;
            case 4:
                repayLoan(scanner, username);
                break;
            case 5:
                updateProfile(scanner, username); 
                break;
            case 6:
                System.out.println("Logging out...");
                Choice();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showUserMenu(scanner, username);
        }
    }

@Override
public void updateProfile(Scanner scanner, String username){
    UserRegistration user = userData.get(username); // Assuming userData stores users
    if (user == null) {
        System.out.println("User not found. Please try again.");
        return;
    }

    System.out.println("\nUpdate Profile:");

    // Update Username
    System.out.print("Username (" + username + "): ");
    String newUsername = scanner.nextLine();
    if (!newUsername.isEmpty() && !newUsername.equals(username)) {
        userData.remove(username); 
        user.setUsername(newUsername); 
        userData.put(newUsername, user); 
        username = newUsername; 
    }

    
    System.out.print("Password: ");
    String newPassword = scanner.nextLine();
    if (!newPassword.isEmpty()) {
        user.setPassword(newPassword);
    }

    
    System.out.print("Email (" + user.getEmailAddress() + "): ");
    String newEmail = scanner.nextLine();
    if (!newEmail.isEmpty()) {
        user.setEmailAddress(newEmail);
    }

    
    System.out.print("Mobile Number (" + user.getMobileNumber() + "): ");
    String newMobile = scanner.nextLine();
    if (!newMobile.isEmpty()) {
        user.setMobileNumber(newMobile);
    }

    // Update Address
    System.out.print("Address (" + user.getBankAccountNumber() + "): ");
    String newAddress = scanner.nextLine();
    if (!newAddress.isEmpty()) {
        user.setBankAccountNumber(newAddress);
    }

    System.out.println("Profile updated successfully!");
    showUserMenu(scanner, username);
}

    @Override
    public void applyForLoan(Scanner scanner, String username) {
        UserRegistration user = userData.get(username);
        if (user == null) {
            System.out.println("User not found. Please try again.");
            return;
        }

        System.out.println("\nPlease select the type of loan you are interested in:");
        System.out.println("1. Personal Loan");
        System.out.println("2. Home Loan");
        System.out.println("3. Business Loan");
        System.out.println("4. Two-Wheeler Loan");
        System.out.println("5. Consumer Durable Loan");
        System.out.println("6. Loan Against Property");
        System.out.println("7. Education Loan");
        System.out.println("8. Travel Loan");
        System.out.println("9. Medical Loan");
        System.out.println("10. Gold Loan");
        System.out.println("11. Consumer Finance");
        System.out.println("12. Student Loan"); // New loan type

        System.out.print("Choose a loan type (1-12): ");
        int loanChoice = scanner.nextInt();
        scanner.nextLine();

        double loanAmount = 0;
        switch (loanChoice) {
            case 1:
                loanAmount = getLoanAmount(scanner, "Personal Loan", 100000, 2500000L);
                break;
            case 2:
                loanAmount = getLoanAmount(scanner, "Home Loan", 100000, 500000000);
                break;
            case 3:
                loanAmount = getLoanAmount(scanner, "Business Loan", 100000, 3000000L);
                break;
            case 4:
                loanAmount = getLoanAmount(scanner, "Two-Wheeler Loan", 10000, 500000);
                break;
            case 5:
                loanAmount = getLoanAmount(scanner, "Consumer Durable Loan", 5000, 500000);
                break;
            case 6:
                loanAmount = getLoanAmount(scanner, "Loan Against Property", 200000, 500000000);
                break;
            case 7:
                loanAmount = getLoanAmount(scanner, "Education Loan", 100000, 30000000);
                break;
            case 8:
                loanAmount = getLoanAmount(scanner, "Travel Loan", 20000, 500000);
                break;
            case 9:
                loanAmount = getLoanAmount(scanner, "Medical Loan", 10000, 15000000);
                break;
            case 10:
                loanAmount = getLoanAmount(scanner, "Gold Loan", 10000, 2500000);
                break;
            case 11:
                loanAmount = getLoanAmount(scanner, "Consumer Finance", 5000, 500000);
                break;
            case 12:
                loanAmount = getLoanAmount(scanner, "Student Loan", 50000, 1000000); // New loan type
                break;
            default:
                System.out.println("Invalid loan type. Please try again.");
                applyForLoan(scanner, username);
                return;
        }

        Loan loan = new Loan(getLoanTypeName(loanChoice), loanAmount);
        user.addLoan(loan);
        System.out.println("Loan application submitted successfully!");
        System.out.println("Waiting for admin approval...");

        boolean isApproved = Admin.Approval(scanner, loan);

        System.out.println("Loan approved: " + isApproved);
        showUserMenu(scanner, username);
    }

    @Override
    public void viewLoanStatus(Scanner scanner, String username) {
        UserRegistration user = userData.get(username);
        if (user == null) {
            System.out.println("User not found. Please try again.");
            return;
        }

        List<Loan> loans = user.getLoans();
        if (loans.isEmpty()) {
            System.out.println("No loans found.");
            showUserMenu(scanner, username);
        } else {
            System.out.println("Your loan status:");
            for (Loan loan : loans) {
                System.out.println("Loan Type: " + loan.getLoanType());
                System.out.println("Loan Amount: $" + loan.getLoanAmount());
                System.out.println("Approval Status: " + (loan.isApproved() ? "Approved" : "Pending"));
                System.out.println("-------------------------");
            }
            showUserMenu(scanner, username);
        }
    }

    @Override
    public void viewPastLoanRepaymentHistory(Scanner scanner, String username) {
        UserRegistration user = userData.get(username);
        if (user == null) {
            System.out.println("User not found. Please try again.");
            return;
        }

        List<Loan> pastLoans = user.getPastLoans();
        if (pastLoans.isEmpty()) {
            System.out.println("No past loans found.");
            showUserMenu(scanner, username);
        } else {
            System.out.println("Your past loan repayment history:");
            for (Loan loan : pastLoans) {
                System.out.println("Loan Type: " + loan.getLoanType());
                System.out.println("Loan Amount: $" + loan.getLoanAmount());
                System.out.println("Repayment Status: Repaid");
                System.out.println("-------------------------");
            }
            showUserMenu(scanner, username);
        }
    }

    @Override
    public void repayLoan(Scanner scanner, String username) {
        UserRegistration user = userData.get(username);
        if (user == null) {
            System.out.println("User not found. Please try again.");
            return;
        }

        List<Loan> loans = user.getLoans();
        if (loans.isEmpty()) {
            System.out.println("No loans found.");
            showUserMenu(scanner, username);
        } else {
            System.out.println("Your loans:");
            for (int i = 0; i < loans.size(); i++) {
                Loan loan = loans.get(i);
                System.out.println((i + 1) + ". Loan Type: " + loan.getLoanType() + ", Amount: ₹" + loan.getLoanAmount());
            }

            System.out.print("Choose a loan to repay (1-" + loans.size() + "): ");
            int loanChoice = scanner.nextInt();
            scanner.nextLine();

            if (loanChoice < 1 || loanChoice > loans.size()) {
                System.out.println("Invalid choice. Please try again.");
                repayLoan(scanner, username);
                return;
            }

            Loan loan = loans.get(loanChoice - 1);
            if (loan.isApproved()) {
                System.out.println("Repaying loan: " + loan.getLoanType() + ", Amount: ₹" + loan.getLoanAmount());

                List<Double> interestRates = new ArrayList<>();
                interestRates.add(5.0);
                interestRates.add(7.0);
                interestRates.add(10.0);
                interestRates.add(6.5);
                interestRates.add(8.0);
                interestRates.add(9.0);
                interestRates.add(7.5); // Interest rate for Student Loan

                Map<String, Double> loanInterestMap = new HashMap<>();
                loanInterestMap.put("Personal Loan", interestRates.get(0));
                loanInterestMap.put("Home Loan", interestRates.get(1));
                loanInterestMap.put("Vehicle Loan", interestRates.get(2));
                loanInterestMap.put("Education Loan", interestRates.get(3));
                loanInterestMap.put("Business Loan", interestRates.get(4));
                loanInterestMap.put("Gold Loan", interestRates.get(5));
                loanInterestMap.put("Student Loan", interestRates.get(6)); // Interest rate for Student Loan

                double interestRate = loanInterestMap.getOrDefault(loan.getLoanType(), 0.0);
                double ActualLoanAmount = loan.getLoanAmount();

                int TotalRepayamount = (int) (ActualLoanAmount + (ActualLoanAmount * interestRate / 100));
                System.out.println("Your Loan Amount is " + TotalRepayamount);
                System.out.println("Enter the Loan Amount to pay");
                int amount = scanner.nextInt();
                scanner.nextLine();

                if (amount == TotalRepayamount) {
                    System.out.println("Loan repaid successfully!");
                    user.repayLoan(loan);
                    showUserMenu(scanner, username);
                } else {
                    System.out.println("Enter the Full Loan amount to pay ");
                    showUserMenu(scanner, username);
                }
            } else {
                System.out.println("Loan is not approved yet. Cannot repay.");
            }
        }
    }

    private static double getLoanAmount(Scanner scanner, String loanType, double minAmount, double maxAmount) {
        double loanAmount = 0;
        do {
            System.out.print("Enter the loan amount for " + loanType + " ($" + minAmount + " to $" + maxAmount + "): ");
            loanAmount = scanner.nextDouble();
            if (loanAmount < minAmount || loanAmount > maxAmount) {
                System.out.println("Invalid amount. Please enter a value between $" + minAmount + " and $" + maxAmount + ".");
            }
        } while (loanAmount < minAmount || loanAmount > maxAmount);
        return loanAmount;
    }

    private static String getLoanTypeName(int loanChoice) {
        switch (loanChoice) {
            case 1:
                return "Personal Loan";
            case 2:
                return "Home Loan";
            case 3:
                return "Business Loan";
            case 4:
                return "Two-Wheeler Loan";
            case 5:
                return "Consumer Durable Loan";
            case 6:
                return "Loan Against Property";
            case 7:
                return "Education Loan";
            case 8:
                return "Travel Loan";
            case 9:
                return "Medical Loan";
            case 10:
                return "Gold Loan";
            case 11:
                return "Consumer Finance";
            case 12:
                return "Student Loan"; // New loan type
            default:
                return "Unknown Loan";
        }
    }
}
