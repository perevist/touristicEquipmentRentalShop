package acceptanceTest;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import com.projectIO.touristicEquipmentRentalShop.model.UserInSystem;
import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import fit.ColumnFixture;
import fit.Fixture;

public class SetUpFitnesse extends ColumnFixture {

    static RentalShopApp rentalShopApp = RentalShopApp.getInstance();

    public SetUpFitnesse() {
    }

    public static void main (String [] args){
        UserInSystem.getInstance().setUserType(UserType.ADMINISTRATOR);

        TestAddItemCategory testAddItemCategory = new TestAddItemCategory();
        TestDeleteItemCategory testDeleteItemCategory = new TestDeleteItemCategory();

        TestRegisterCustomer testRegisterCustomer = new TestRegisterCustomer();
        TestDeleteCustomer testDeleteCustomer = new TestDeleteCustomer();
    }
}
