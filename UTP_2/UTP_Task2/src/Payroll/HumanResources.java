package Payroll;

import com.Company.Employee;
import com.Company.Manager;
import com.Company.Trainee;
import com.Company.Worker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanResources{

    // 1. preparing payroll for all the employees
    public static List<PayrollEntry> payroll(List<Employee> employees) {

        return employees.stream()
                .map(employee -> {
            BigDecimal bonus = employee instanceof Worker ? ((Worker)employee).get_bonus() : null;
            return new PayrollEntry(employee);
        }).collect(Collectors.toList());
    }
    //2. preparing payroll for subordinates of the given manager;
    public static List<PayrollEntry> subordinatesPayroll(Manager manager) {

        return manager.getAllSubordinates().stream().map(employee -> {
           BigDecimal bonus = employee instanceof Worker ? ((Worker) employee).get_bonus() : null;
           return new PayrollEntry((Worker)employee);
        }).collect(Collectors.toList());

    }
    // 3. calculating the total cost of bonuses;
    public static BigDecimal bonusTotal(List<Employee> employees) {

        return employees.stream()
                .filter(employees1 -> employees1 instanceof Worker)
                .map(employee -> ((Worker) employee).get_bonus())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    //4. searching for an employee with the longest seniority;
    public static LocalDate longestSeniority(List<Employee> employees){

        return employees.stream()
                .filter(employees1 -> employees1 instanceof Worker)
                .map(employee -> ((Worker)employee).get_empDate())
                .max(LocalDate::compareTo).get();
    }

    //5. searching for the highest salary without bonus (a number should be returned);
    public static BigDecimal highestSalNoBonus(List<Employee> employees){

        return employees.stream()
                .filter(employee -> employee instanceof Worker)
                .map(Employee::get_sal)
                .max(BigDecimal::compareTo).get();
    }

    // 6. searching for the highest salary with bonus (a number should be returned);
    public static BigDecimal highestSalBonus(List<Employee> employees){

        return employees.stream()
                .filter(employees1 -> employees1 instanceof Worker)
                .map(employee -> ((Worker)employee).get_salWithBonus())
                .max(BigDecimal::compareTo).get();
    }
    // 7. searching for employees whose surnames begin with ‘A’ subordinates of the given manager;
    public static List<Employee>beginWithA(List<Employee> employees){

        return employees.stream()
                .filter(employee -> employee.get_surname().startsWith("A")).collect(Collectors.toList());
    }
    // 8. Searching for employees who earn more than 1000 PLN.*/
    public static List<Employee> salGreaterThousand(List<Employee> employees, BigDecimal itsOver1000){
        return employees.stream()
                .filter(employee -> employee.get_sal().compareTo(itsOver1000)>0)
                .collect(Collectors.toList());
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // The best solution is to impleent the below features as static methods having a list of Employee as the first input argument.
    // In addition the list of arguments may be augmented with parameters required for the given feature.

    // (assignment 03)
    // methods:
    //
    // * search for Employees older than given employee and earning less than him
    public static Worker convert(Employee e ){
        return (Worker)e;
    }
    public static Boolean check(Employee e){
        return e instanceof Trainee;
    }
    public static List<Employee> olderThenAndEarnLess(List<Employee> allEmployees, Employee employee) {
        return allEmployees.stream()
                .filter(employees -> employees.isOlder(employee))
                .filter(employees -> employees.salLess(employee.get_sal()))
                .collect(Collectors.toList());
    }
    // * search for Trainees whose practice length is longer than given number of days and raise their salary by 5%
    public static ArrayList practiceLengthLongerThan(List<Employee> allEmployees, int daysCount) {
        BigDecimal b1 = new BigDecimal(1.05);
        ArrayList arr = new ArrayList();
        allEmployees.stream().filter(HumanResources::check).map(worker -> HumanResources::convert(Trainee))
                .forEach(employee -> {
                    if (((Trainee) employee).isLonger(daysCount)){
                            employee.set_sal(employee.get_sal().multiply(b1));
                        arr.add(employee);)
                }});
        return arr;
    }

    //
    // * search for Workers whose seniority is longer than given number of months and give them bonus of 300 if their bonus is smaller
    public static List seniorityLongerThan(List<Employee> allEmployees, int monthCount) {
        List arrayList = new ArrayList();
        BigDecimal b1 = new BigDecimal(300);
        allEmployees.forEach(employee -> {
            if(employee instanceof Worker && ((Worker)employee).seniorityIsLongerThanGivenMonths(monthCount) && (employee.salLess(b1))){
                  employee.set_sal(employee.get_sal().add(b1));
            }
            arrayList.add(employee);
                });
        return arrayList;

    }

    //
    // * search for Workers whose seniority is between 1 and 3 years and give them raise of salary by 10%
    public static ArrayList seniorityBetweenOneAndThreeYears(List<Employee> allEmployees) {
        BigDecimal b1 = new BigDecimal(1.1);
        ArrayList temp = new ArrayList();
        allEmployees.forEach(employee -> {
                if(employee instanceof Worker &&(((Worker)employee).seniorityIsLongerThanGivenYears(1)
                        &&((Worker)employee).seniorityIsLongerThanGivenYears(3))){
                employee.set_sal(b1);
        }
            temp.add(employee);
        });

        return temp;
    }

    //
    // * search for Workers whose seniority is longer than the seniority of a given employee and earn less than him and align their salary with the given employee
    public static ArrayList seniorityLongerThanGiven(List<Employee> allEmployees, Employee employee) {
        ArrayList temp = new ArrayList();
        allEmployees.forEach(employee1 -> {
            if(employee1 instanceof Worker && (((Worker) employee1).seniorityIsLongerThanGivenYears(((Worker)employee).get_empDate().getYear()))
                    && employee1.get_sal().compareTo(employee.get_sal())>0){
                employee1.set_sal(employee.get_sal());
            }
        });
        temp.add(employee);
       return temp;
    }

    //
    // * search for Workers whose seniority is between 2 and 4 years and whose age is greater than given number of years
    public static List<Worker> seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(List<Employee> allEmployees, int age) {
        allEmployees.stream()
                .filter(employee -> employee instanceof Worker ? (((Worker)employee).seniorityIsLongerThanGivenYears(2)
                        &&((Worker)employee).seniorityIsLessThanGivenYears(4)&&employee.getAge().compareTo(age)>0):null);
        ArrayList temp = new ArrayList();
        temp.add(allEmployees);
        return temp;

    }

}
