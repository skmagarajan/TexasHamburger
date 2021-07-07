package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.CustomerOrderDTO;

public interface OrderService {
    Boolean createOrder(CustomerOrderDTO order);
}
