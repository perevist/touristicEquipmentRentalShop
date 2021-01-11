package acceptanceTest;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import fit.ColumnFixture;

public class TestAddItemCategory extends ColumnFixture {

    public boolean addItemCategory() {
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;

        int initialSize = rentalShopApp.getAllItemCategories().size();

        // Add new item category
        rentalShopApp.addItemCategory("rower2", 15, 56);

        int finalSize = rentalShopApp.getAllItemCategories().size();

        return finalSize == initialSize + 1;
    }
}
