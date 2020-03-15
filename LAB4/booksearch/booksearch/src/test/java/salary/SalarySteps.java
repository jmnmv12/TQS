package salary;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SalarySteps {
    SalaryManager manager;

    @Given("the salary management system is initialized with the following data")
    public void the_salary_management_system_is_initialized_with_the_following_data(final List<Employee>employees)  {
        manager = new SalaryManager(employees);
    }

    @When("the boss increases the salary for the employee with id {string} by {int}%")
    public void the_boss_increases_the_salary_for_the_employee_with_id_by(final String id, final int increaseInPercent) throws Throwable {
        manager.increaseSalary(Integer.parseInt(id), increaseInPercent);
    }




    @Then("the payroll for the employee with id {string} should display a salary of {int}")
    public void the_payroll_for_the_employee_with_id_should_display_a_salary_of(final String id, final float salary) throws Throwable {
        Employee nominee = manager.getPayroll(Integer.parseInt(id));
        assertThat(nominee.getSalary(), equalTo(salary));
    }
}
