package acceptanceTest;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import fit.Fixture;

public class SetUpFitnesse extends Fixture {

    static RentalShopApp rentalShopApp = RentalShopApp.getInstance();

    public SetUpFitnesse() {
    }

}
