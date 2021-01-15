package acceptanceTest;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import fit.ColumnFixture;

public class TestRegisterCustomer extends ColumnFixture {

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;


    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean registerCustomer() {
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;
        int initialSize = rentalShopApp.getAllCustomers().size();

        // register Customer
        try{
            rentalShopApp.registerCustomerInSystem(login, firstName, lastName, phoneNumber, email, password);
        }
        catch (Exception e){
            return false;
        }


        int finalSize = rentalShopApp.getAllCustomers().size();

        return finalSize == initialSize + 1;
    }


    public int getAllCustomers(){
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;
        return rentalShopApp.getAllCustomers().size();
    }

}