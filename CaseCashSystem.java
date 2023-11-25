import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CaseCashSystem {
    
    // the list of students with accounts created
    private List<Student> students = new ArrayList<Student>();

    // public List<String> runSimulation(List<String> commands) {

    // }

    /**
     * Initializes a new student with the given name and initial balance
     * @param name the new name of the student
     * @param initialBalance the new balance of the student
     * @return false if a student with the same name already exists
     * @return true if the student has not already been created
     */
    public boolean init(String name, int initialBalance) {
        // return false if the initial balance is less than 0
        if (initialBalance < 0) {
            return false;
        }
        
        // return false if a student with the same name already exists
        if (students.size() != 0) {
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    return false;
                }
            }
        }
        
        // add the student to the list of students if none of the conditions are met
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
        // find the student in the list, and return their balance if they exist
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.getBalance();
            }
        }

        // return -1 if the student does not exist
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
    public boolean transfer(Student studentA, Student studentB, int amount) {
        if (amount < 0 || studentA == null || studentB == null || studentA.getBalance() < amount) {
            // return false if amount is less than 0, either of the students are not found, or student A does not have the right balance
            return false;
        } else {
            // update the balances for both students if none of the conditions are met
            studentA.updateBalance(studentA.getBalance() - amount);
            studentB.updateBalance(studentB.getBalance() + amount);
            return true;
        }
    }
    
    /**
     * Sorts all of the students' names in alphabetical order utilizing merge sort
     * @return a list of the students' names in alphabetical order
     */
    public List<String> sortName() {
        // update the list of students to be sorted by their names
        students = mergeSort(students);

        // return a list of names in the sorted order
        List<String> names = new ArrayList<>(students.size());
        for (Student student : students) {
            names.add(student.getName());
        }
        return names;
    }

    /**
     * Sorts students' names in order of their balance utilizing quick sort (low to high)
     * @return a list of the students' names in order of their balance
     */
    public List<String> sortBalance() {
        // update the list of students to be sorted by their account balance
        quickSort(students, 0, students.size() - 1);

        // return a list of names in the sorted order
        List<String> names = new ArrayList<>(students.size());
        for (Student student : students) {
            names.add(student.getName());
        }
        return names;
    }

    /**
     * Removes money from a student's account
     * @param student the student to withdraw from
     * @param amount the amount to withdraw
     * @return false if the amount to withdraw is negative or greater than the amount in the student's account
     * @return true if the withdrawal was successful and the student's account was updated
     */
    public boolean withdrawal(Student student, int amount) {
        if (student == null || amount < 0 || student.getBalance() < amount) {
            // return false if the student is not found, the amount to withdraw is negative, or the student does not have the right balance
            return false;
        } else {
            // update the balance of the student if none of the conditions are met
            student.updateBalance(student.getBalance() - amount);
            return true;
        }
    }

    /**
     * Helper implementation for a merge sort with the list of Students
     * @param list the List of Students to sort
     * @return the sorted List of Students
     */
    private List<Student> mergeSort(List<Student> list) {
        // base case
        if (list.size() <= 1) {
            return list;
        }

        // create a left and right side of the list
        List<Student> left = new ArrayList<>();
        List<Student> right = new ArrayList<>();

        // find the middle of the list
        int middle = list.size() / 2;

        // add the elements to the left and right sides of the list
        for (int i = 0; i < middle; i++) {
            left.add(list.get(i));
        }
        for (int i = middle; i < list.size(); i++) {
            right.add(list.get(i));
        }

        // recursively call mergeSort on the left and right sides of the list
        left = mergeSort(left);
        right = mergeSort(right);

        // merge all the results together
        return merge(left, right);
    }

    /**
     * Helper implementation for a merge sort with the list of Students
     * @param left the Left list of Students to merge
     * @param right the Right list of Students to merge
     * @return the merged List of Students
     */
    private List<Student> merge(List<Student> left, List<Student> right) {
        // create a new list to store the merged results
        List<Student> result = new ArrayList<>();

        // merge the two lists together until one of them is empty
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).getName().compareTo(right.get(0).getName()) < 0) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
        }

        // add the remaining elements of the left and right lists to the result list
        result.addAll(left);
        result.addAll(right);

        // return the merged list of Students
        return result;
    }

    /**
     * Helper implementation for a quick sort with the list of Students
     * @param list the List of Students to be sorted
     * @param first the first item in the list to be sorted
     * @param last the last item in the list to be sorted
     */
    private void quickSort(List<Student> list, int first, int last) {
        // base case: if the list has only one element, it is already sorted
        if (first < last) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Helper implementation for a quick sort with the list of Students
     * @param list the List of Students to be sorted
     * @param first the first element in the List
     * @param last the last element in the List which is also the pivot element
     * @return the first index position
     */
    private int partition(List<Student> list, int first, int last) {
        // choose the pivot element as the last element in the list
        int pivot = list.get(last).getBalance();
        int i = first - 1;
        
        // move elements smaller than the pivot to the left of the pivot and elements larger than the pivot to the right of the pivot
        for (int j = first; j < last; j++) {
            if (list.get(j).getBalance() <= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        // move the pivot element to the correct position in the list
        Collections.swap(list, i + 1, last);

        // return the first position in the list
        return i + 1;
    }
    
    public static void main(String[] args) {
        CaseCashSystem cashSystem = new CaseCashSystem();
        cashSystem.init("John", 100);
        cashSystem.init("Jane", 200);
        cashSystem.init("Bob", 300);
        cashSystem.init("Alice", 400);
        cashSystem.init("Charlie", 500);
        cashSystem.init("David", 600);
        cashSystem.init("Eve", 700);
        cashSystem.init("Frank", 800);
        cashSystem.init("Gina", 900);
        cashSystem.init("Harry", 1000);
        System.out.println(cashSystem.sortBalance());

        // System.out.println(cashSystem.getBalance("John")); // 100
        // System.out.println(cashSystem.getBalance("Jane")); // 200
        // System.out.println(cashSystem.getBalance("Bob")); // 300

        // cashSystem.transfer("John", "Jane", 50);
        // cashSystem.transfer("Jane", "Bob", 25);

        // System.out.println(cashSystem.getBalance("John")); // 50
        // System.out.println(cashSystem.getBalance("Jane")); // 175
        // System.out.println(cashSystem.getBalance("Bob")); // 275

        // List<String> names = cashSystem.sortName();
        // System.out.println(names); // ["Bob", "Jane", "John"]
    
    }
}

