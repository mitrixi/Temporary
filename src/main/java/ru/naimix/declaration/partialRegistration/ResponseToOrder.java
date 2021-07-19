package ru.naimix.declaration.partialRegistration;

/**
 * В чек-листе: "Нельзя откликнуться на заказ"
 */
public interface ResponseToOrder {

    void selectOrder();
    void selectRespondToOrder();
    void goToMainMenuFromRTO();
}
