import java.util.List;
import java.util.ArrayList;

public class CaseCashSystem {
    
    // the list of students with accounts created
    private List<Student> students;

    public List<String> runSimulation(List<String> commands) {

    }

    /**
     * Initializes a new student with the given name and initial balance
     * @param name the new name of the student
     * @param initialBalance the new balance of the student
     * @return false if a student with the same name already exists
     * @return true if the student has not already been created
     */
    public boolean init(String name, int initialBalance) {
        if (initialBalance < 0) {
            return false;
        }
        
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return false;
            }
        }
        
        students.add(new Student(name, initialBalance));
        return true;
        
    }

    /**
     * Returns the balance of a given student
     * @param name the name of the student to retrieve their balance
     * @return the balance of the student
     * @return -1 if the student does not exist
     */
    public int getBalance(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.getBalance();
            }
        }
        return -1;
    }

    /**
     * Transfers the amount from studentA account to studentB's account
     * @param studentA the account to transfer from
     * @param studentB the account to transfer to
     * @param amount the amount to transfer
     * @return false if transferring money from A to B will result in a negative balance, if the transfer amount is negative, 
     * @return true if the transfer was successful
     */
    public boolean transfer(String studentA, String studentB, int amount) {
        Student stA = null;
        Student stB = null;

        // find students A and B
        for (Student student : students) {
            if (student.getName().equals(studentA)) {
                stA = student;
            } else if (student.getName().equals(studentB)) {
                stB = student;
            }
        }
        
        if (amount < 0 || stA == null || stB == null || stA.getBalance() < amount) {
            // return false if amount is less than 0, either of the students are not found, or student A does not have the right balance
            return false;
        } else {
            // update the balances for both students if none of the conditions are met
            stA.updateBalance(stA.getBalance() - amount);
            stB.updateBalance(stB.getBalance() + amount);
            return true;
        }

    }
    
    public List<String> sortName() {
        
    }

    private void mergeSort(List<Student> students) {
        List<Student> temp = new ArrayList<Student>(students.size());
        myMergeSort(students, temp, 0, students.size() - 1);
    }

    private void myMergeSort(Student[] arr, Student[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        myMergeSort(arr, temp, start, middle);
        myMergeSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
}

