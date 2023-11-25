/**
 * Individual implementation for each student in the CaseCash system
 * @author Nikhil Jindal
 */
public class Student {
    
    // the name of the student
    private String name;

    // the current balance in the student account
    private int balance;

    // constructor for the Student class
    public Student(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    /**
     * Returns the balance the student has in their account
     * @return the balance the student has in their account
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Returns the name of the student
     * @return the name of the student
     */
    public String getName() {
        return this.name;
    }

    /**
     * Updates the balance has in their account
     * @param newAmount the amount to update the balance by
     */
    public void updateBalance(int newAmount) {
        this.balance = newAmount;
    }
}
