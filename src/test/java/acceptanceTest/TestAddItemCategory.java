package acceptanceTest;

import com.projectIO.touristicEquipmentRentalShop.application.RentalShopApp;
import fit.ColumnFixture;

public class TestAddItemCategory extends ColumnFixture {


    private String name;
    private double rentalCharge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentalCharge() {
        return rentalCharge;
    }

    public void setRentalCharge(double rentalCharge) {
        this.rentalCharge = rentalCharge;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    private double deposit;

    //zwraca 'true' gdy dodano pomyślnie jedną kategorię - ilość kategorii zwiększyła się o jeden
    public boolean addItemCategory( ) {
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;

        int initialSize = rentalShopApp.getAllItemCategories().size();

        // Add new item category
        try {
            rentalShopApp.addItemCategory(name, rentalCharge, deposit);
        }
        catch(Exception e){
            return false;
        }

        int finalSize = rentalShopApp.getAllItemCategories().size();
        return finalSize == initialSize + 1;
    }

    public int getAllItemCategories(){
        RentalShopApp rentalShopApp = SetUpFitnesse.rentalShopApp;
        return rentalShopApp.getAllItemCategories().size();
    }

}
