package ru.naimix.device;

import ru.naimix.declaration.TestDeclaration;
import ru.naimix.declaration.partialRegistration.*;

/**
 * Разделение декларируемых методов на интерфейсы по отдельным тестовым кейсам довольно условное.
 * Сделано для чуть большего удобства навигации по ним, в случае необходимости.
 * Некоторые методы(сигнатуры методов, но с разной реализацией) дублируются в разных тесткейсах.
 */
public abstract class Device /*implements PartialRegistration,
                                        MyOrdersMenu,
                                        SearchForOrders,
                                        ResponseToOrder,
                                        ProfileMenu,
                                        SupportMenu*/ {
    public TestDeclaration testDeclaration;
}

