package ru.naimix.declaration;

import ru.naimix.declaration.partialRegistration.*;

public interface TestDeclaration extends PartialRegistration,
                                         MyOrdersMenu,
                                         SearchForOrders,
                                         ResponseToOrder,
                                         ProfileMenu,
                                         SupportMenu {
}
