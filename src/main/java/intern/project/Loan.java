package intern.project;

public class Loan {
    private String loanType;
    private double loanAmount;
    private boolean isApproved;

    public Loan(String loanType, double loanAmount) {
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.isApproved = false;
    }

    public String getLoanType() {
        return loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
