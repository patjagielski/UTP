package Payroll;

import java.math.BigDecimal;
import com.Company.Employee;
import com.Company.Manager;
import com.Company.Trainee;
import com.Company.Worker;

public class PayrollEntry {

    private final Employee _employee;
    private final BigDecimal _salary;
    private final BigDecimal _salbonus;


    public PayrollEntry(Employee _employee){
        this._employee = _employee;
        _salary = _employee.get_sal();
        _salbonus = null;
    }
    public PayrollEntry(Worker worker){
        _employee = worker;
        _salary = worker.get_sal();
        this._salbonus = worker.get_bonus().add(_salary);

    }
    public PayrollEntry(Trainee trainee){
        _employee = trainee;
        _salary = trainee.get_sal();
        _salbonus = null;
    }
    public PayrollEntry(Manager manager){
        _employee = manager;
        _salary = manager.get_sal();
        _salbonus = null;
    }

    public BigDecimal get_salbonus() {
        return _salbonus;
    }

    public BigDecimal get_salary() {
        return _salary;
    }

    public Employee get_employee() {
        return _employee;
    }

}

