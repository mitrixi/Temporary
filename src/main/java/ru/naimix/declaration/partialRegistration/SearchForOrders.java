package ru.naimix.declaration.partialRegistration;

import ru.naimix.model.OrderFilter;

/**
 * В чек-листе: "Поиск заказов"
 */
public interface SearchForOrders {

    void selectSearch();
    void selectFilters();
    void enterNameOrder();
    void showResult(OrderFilter orderFilter);
    void selectFilterCustomer();
    void selectCustomer();
    void applyFilter(OrderFilter orderFilter);
    void enterOrderAmount();
    void selectFilterRegion();
    void selectRegion();
    void selectFilterCategory();
    void selectCategory();
    void goToMainMenu();
    void resetFilters();
}
