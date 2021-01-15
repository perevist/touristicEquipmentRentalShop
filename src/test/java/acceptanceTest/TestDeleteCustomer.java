package acceptanceTest;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import fit.ColumnFixture;

public class TestDeleteCustomer extends ColumnFixture {

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public boolean removeCustomer( ) {
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;
        int initialSize = rentalShopApp.getAllCustomers().size();

        // Remove customer
        try {
            rentalShopApp.removeCustomer(login);
        }
        catch (Exception e){
            return false;
        }

        int finalSize = rentalShopApp.getAllCustomers().size();
        return finalSize == initialSize - 1;
    }

    public int getAllCustomers(){
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;
        return rentalShopApp.getAllCustomers().size();
    }

}
