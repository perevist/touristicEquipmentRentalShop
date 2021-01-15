package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.ocadotechnology.gembus.test.Arranger;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.ItemCategoryDAO;
import com.projectIO.touristicEquipmentRentalShop.model.ItemCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityExistsException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class ItemCategoryServiceImplTest {

    @Mock
    private ItemCategoryDAO itemCategoryDAO;

    @InjectMocks
    private ItemCategoryServiceImpl itemCategoryService;

    @Test
    void shouldThrowExceptionIfItemCategoryNameIsNull() {
        // given
        String name = null;
        double rentalCharge = Arranger.somePositiveInt(100);
        double deposit = Arranger.somePositiveInt(100);
        // when
        // then
        assertThatThrownBy(() -> itemCategoryService.addItemCategory(name, rentalCharge, deposit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Podano nieprawidłowe dane");

    }

    @Test
    void shouldThrowExceptionIfItemCategoryNameIsEmpty() {
        // given
        String name = "";
        double rentalCharge = Arranger.somePositiveInt(100);
        double deposit = Arranger.somePositiveInt(100);
        // when
        // then
        assertThatThrownBy(() -> itemCategoryService.addItemCategory(name, rentalCharge, deposit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Podano nieprawidłowe dane");
    }

    @Test
    void shouldThrowExceptionIfItemCategoryRentalChargeIsLowerThanZero() {
        // given
        String name = Arranger.someText(1, 20);
        double rentalCharge = -Arranger.somePositiveInt(100);
        double deposit = Arranger.somePositiveInt(100);
        // when
        // then
        assertThatThrownBy(() -> itemCategoryService.addItemCategory(name, rentalCharge, deposit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Podano nieprawidłowe dane");
    }

    @Test
    void shouldThrowExceptionIfItemCategoryDepositIsLowerThanZero() {
        // given
        String name = Arranger.someText(1, 20);
        double rentalCharge = Arranger.somePositiveInt(100);
        double deposit = -Arranger.somePositiveInt(100);
        // when
        // then
        assertThatThrownBy(() -> itemCategoryService.addItemCategory(name, rentalCharge, deposit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Podano nieprawidłowe dane");
    }


    @Test
    void shouldGetAllItemCategories() {
        // given
        Mockito.when(itemCategoryDAO.readAll()).thenReturn(Arrays.asList(
                new ItemCategory("Rower", 34.2, 12.3),
                new ItemCategory("Kajak", 56, 12),
                new ItemCategory("Lodka", 47, 14)
        ));
        // when
        List<ItemCategory> allCategories = itemCategoryService.getAllCategories();
        // then
        assertThat(allCategories).isNotNull();
        assertThat(allCategories).hasSize(3);
    }

    @Test
    void shouldDeleteItemCategory() {
        // given
        int id = Arranger.somePositiveInt(100);
        // when
        itemCategoryService.removeItemCategory(id);
        // then
        Mockito.verify(itemCategoryDAO, Mockito.times(1)).delete(id);
    }

    @Test
    void shouldUpdateItemCategory() {
        // given
        ItemCategory itemCategory = new ItemCategory("Rower", 34.2, 12.3);
        // when
        itemCategoryService.updateItemCategory(itemCategory);
        // then
        Mockito.verify(itemCategoryDAO, Mockito.times(1)).update(itemCategory);
    }

    @Test
    void shouldAddItemCategory() {
        // given
        String name = Arranger.someText(1, 20);
        double rentalCharge = Arranger.somePositiveInt(100);
        double deposit = Arranger.somePositiveInt(100);
        // when
        itemCategoryService.addItemCategory(name, rentalCharge, deposit);
        // then
        Mockito.verify(itemCategoryDAO, Mockito.times(1))
                .save(ArgumentMatchers.any(ItemCategory.class));
    }

    @Test
    void shouldThrowExceptionIfCategoryNameIsNotUnique() {
        // given
        String name = Arranger.someText(1, 20);
        double rentalCharge = Arranger.somePositiveInt(100);
        double deposit = Arranger.somePositiveInt(100);
        Mockito.doThrow(EntityExistsException.class).when(itemCategoryDAO).
                save(ArgumentMatchers.any(ItemCategory.class));
        // when
        // then
        assertThatThrownBy(() -> itemCategoryService.addItemCategory(name, rentalCharge, deposit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nazwa kategorii nie jest unikalna");
    }
}