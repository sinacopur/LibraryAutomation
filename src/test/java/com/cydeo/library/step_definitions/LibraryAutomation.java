package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.DB_Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LibraryAutomation {


    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        DB_Utilities.createConnection(ConfigurationReader.getProperty("JDBC_URL"),
                ConfigurationReader.getProperty("DB_username"),
                ConfigurationReader.getProperty("DB_password"));


    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

        DB_Utilities.runQuery("SELECT COUNT(DISTINCT id) FROM users");

    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

    int actualID = 141;
    int expectedID = Integer.parseInt(DB_Utilities.getFirstRowFirstColumn());

        Assert.assertEquals(actualID,expectedID);

    }


    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        DB_Utilities.runQuery("SELECT * FROM users");

        DB_Utilities.getAllColumnNamesAsList();


    }


    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> dataTable) {

        Assert.assertEquals(dataTable, DB_Utilities.getAllColumnNamesAsList());



    }

}
