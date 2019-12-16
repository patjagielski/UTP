package Test;

import Payroll.HumanResources;
import Payroll.PayrollEntry;
import com.Company.Employee;
import com.Company.Manager;
import com.Company.Trainee;
import com.Company.Worker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class HumanResourcesTest {



    private static final List<PayrollEntry> _payRolls = new ArrayList<>();
    private List<Employee>_allEmployees = new ArrayList<>();

    private Manager topManager = new Manager("Patrik", "Jagielski", LocalDate.of(1990, 2, 4), new BigDecimal(1000000), null , null );
    private List<Manager> _allManagers = new ArrayList<>();
    Manager olFaithful = new Manager("Bill", "Anderson", LocalDate.of(1850, 1, 1), new BigDecimal(50000), new BigDecimal(500), topManager );

    @AfterClass
    public static void after(){
        List<Manager> _allEmployees= new ArrayList<>();
        _allEmployees.clear();
    }
    public List<Manager> generateManagers(){

        BigDecimal salaries = new BigDecimal(100000);
        _allManagers.add(topManager);
        _allManagers.add(olFaithful);
        Manager firstManager1 = new Manager("Alex", "Martynek", LocalDate.of(1997, 2, 1), salaries,new BigDecimal(500), topManager);
        Manager secondManager2 = new Manager("Rob", "Anowlton", LocalDate.of(1996, 9, 25), salaries, new BigDecimal(500), topManager);
        Manager thirdManager3 = new Manager("Weronika", "Wawrzyniak", LocalDate.of(1998, 5, 10),salaries, new BigDecimal(500), topManager);
        _allManagers.add(firstManager1);
        _allManagers.add(secondManager2);
        _allManagers.add(thirdManager3);
        return _allManagers;
    }

    public List<Employee> generateAllEmployees(){
        _allEmployees.addAll(generateManagers());
         for(int i = 0; i< 20; i++){
             if(i <10){
                 BigDecimal trainSalaries = new BigDecimal(1000);
                 Trainee generic = new Trainee("John", "Atag", LocalDate.of(1999, 1, 1), trainSalaries, null, LocalDate.of(2013, 1, 1));
                 _allEmployees.add(generic);
                 _payRolls.add(new PayrollEntry(_allEmployees.get(i)));

             }
             else if(i>=10){
                 BigDecimal workerSal = new BigDecimal(5000);
                 BigDecimal workerBonus = new BigDecimal(500);
                 Worker generica = new Worker("Jane", "Doe", LocalDate.of(1999, 1, 1), workerSal, workerBonus, null);
                 _allEmployees.add(generica);
                 _payRolls.add(new PayrollEntry(_allEmployees.get(i)));
             }
         }


         return _allEmployees;
    }


/*

    @Test
    void shouldReturnPayroll() {
        Assert.assertSame(24, generateAllEmployees().size());
    }

    @Test
    void shouldReturnSubordinatesPayroll() {
        Assert.assertEquals(24, generateAllEmployees().size());

    }

    @Test
    void shouldReturnBonusTotal() {
        Assert.assertEquals(new BigDecimal(6500), HumanResources.bonusTotal(generateAllEmployees()));

    }

    @Test
    void longestSeniority() {
        LocalDate longestSen = LocalDate.of(1990, 2, 4);
        Assert.assertEquals(topManager.get_empDate(), longestSen );

    }

    @Test
    void highestSalNoBonus() {

        Assert.assertEquals(topManager.get_sal(), HumanResources.highestSalNoBonus(generateAllEmployees()));
    }

    @Test
    void highestSalBonus() {

        Assert.assertEquals(new BigDecimal(1000000), HumanResources.highestSalBonus(generateAllEmployees()));
    }

    @Test
    void beginWithA() {
        Assert.assertEquals(1, HumanResources.beginWithA(generateAllEmployees()).size());
    }

    @Test
    void salGreaterThousand() {

        Assert.assertEquals(14, HumanResources.salGreaterThousand(generateAllEmployees(), new BigDecimal(1000)).size());
    }
    */
    //////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void olderThenAndEarnLess(){

        Assert.assertEquals(1,HumanResources.olderThenAndEarnLess(generateAllEmployees(), topManager).size());

    }

    @Test
    void practiceLengthLongerThan(){
        Assert.assertEquals(10, HumanResources.practiceLengthLongerThan(generateAllEmployees(), 15).size());
    }

    @Test
    void seniorityLongerThan(){
        Assert.assertEquals(25, HumanResources.seniorityLongerThan(generateAllEmployees(),20).size());
    }
    @Test
    void seniorityBetweenOneAndThreeYears(){
        Assert.assertEquals(25, HumanResources.seniorityBetweenOneAndThreeYears(generateAllEmployees()).size());
    }
    @Test
    void seniorityLongerThanGiven(){
        Assert.assertEquals(1, HumanResources.seniorityLongerThanGiven(generateAllEmployees(), topManager).size());
    }
    @Test
    void seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(){
        Assert.assertEquals(1, HumanResources.seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(generateAllEmployees(), 30).size());
    }

}