package acceptanceTest;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import fit.ColumnFixture;

public class TestDeleteItemCategory extends ColumnFixture {


    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean removeItemCategory( ) {
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;
        int initialSize = rentalShopApp.getAllItemCategories().size();

        // Remove item category
        try {
            rentalShopApp.removeItemCategory(id);
        }
        catch (Exception e){
            return false;
        }

        int finalSize = rentalShopApp.getAllItemCategories().size();
        return finalSize == initialSize - 1;
    }

    public int getAllItemCategories(){
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;
        return rentalShopApp.getAllItemCategories().size();
    }

}
