# SortingAlgorithms

This repository contains three classes: `Student.java`, `CaseCashSystem.java`, and `CaseCashSystemTest.java`. These files build off of Case Western Reserve University's campus cash which is called CaseCash. 

The point of this repository is to implement the following functionalities with the CaseCash plan:
- Transfer of CaseCash from Student A to Student B
- Deposit CaseCash into a Student account
- Withdraw CaseCash
- View student account balance
- Be able to sort students by name and account balance (using different sorting algorithms)

----

The `Student.java` class has the following functionalities:
- `int getBalance()` - returns the CaseCash balance the student has in their account
- `void updateBalance(int newAmount)` - updates the CaseCash balance the student has in their account

----

The `CaseCashSystem.java` class has the following functionalities:
- `List<String> runSimulation(List<String> commands)` - this parses the commands it is given, calls the respective helper functions, and runs a simulation provided based on the commands it is given (more details regarding the inputs are given below)
- `boolean init(String name, int initialBalance)` - initializes a student with the name and initial CaseCash balance given, returning false if the initial balance is negative or a student with the same name already exists
- `int getBalance(String name)` - returns the balance of a student given their name
- `boolean deposit(Student student, int amount)` - deposits CaseCash to a student's account, returning false if the deposit fails
- `boolean transfer(Student studentA, Student studentB, int amount)` - transfers the amount of CaseCash from studentA to studentB's account, returning false if the transfer was unsuccessful or the amount was negative
- `List<String> sortName()` - returns a list of student's names in alphabetical order using a customized implementation of **merge sort**
- `List<String> sortBalance()` - returns a list of student's name in the order of smallest balance to largest balance in their account using a customized implementation of **quick sort**
- `boolean withdrawal(Student student, int amount)` - removes CaseCash from a student's account, returning false if the transaction will result in a negative balance

----

### Inputs

Inputs are given to the simulation in the following format:
- “**INIT**, name, initialBalance”
- “**GET**, name”
- “**TRANSFER**, studentA, studentB, amount”
- “**WITHDRAWAL**, studentA, amount”
- “**DEPOSIT**, studentA, amount”
- “**SORT**, name or balance”

Each of the bolded keywords corresponds directly to one of the methods in the `CaseCashSystem.java` class. 

Here is an example simulation:

    List<String> inputs = [“INIT, Tammy, 200”,
                            “INIT, Kim, 300”,
                            “INIT, Quyen, 400”,
                            “SORT, name”,
                            “SORT, balance”,
                            “TRANSFER, Kim, Tammy, 100”,
                            “SORT, name”,
                            “SORT, balance”];

    System.out.println(runSimulation(List<String> inputs))
    >>> [“true”,
        “true”,
        “true”,
        “[Kim, Quyen, Tammy]”,
        “[Tammy, Kim, Quyen]”,
        “true”,
        “[Kim, Quyen, Tammy]”,
        “[Kim, Tammy, Quyen]”]

----

### JUnit Testing

The `CaseCashSystemTest.java` class contains thorough JUnit testing for each of the methods in the `CaseCashSystem.java` class. All of the JUnit tests pass, and therefore the customized implementations of **merge sort** and **quick sort** correctly sort the student's names and balances.
