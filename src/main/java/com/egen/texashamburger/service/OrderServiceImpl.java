package com.egen.texashamburger.service;

import com.egen.texashamburger.dto.CustomerOrderDTO;
import com.egen.texashamburger.entity.CustomerOrder;
import com.egen.texashamburger.entity.MenuItem;
import com.egen.texashamburger.exception.MenuServiceException;
import com.egen.texashamburger.exception.OrderServiceException;
import com.egen.texashamburger.repository.MenuItemRepository;
import com.egen.texashamburger.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    private MenuItemRepository menuItemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public Boolean createOrder(CustomerOrderDTO order) {
        try{
            CustomerOrder orderEntity = new CustomerOrder();
            BeanUtils.copyProperties(order, orderEntity);
            BigDecimal prizeTotal = new BigDecimal(0.00);
            for(int i=0;i<order.getItemsOrdered().size();i++){
                String menuName = order.getItemsOrdered().get(i);
                List<MenuItem> item = menuItemRepository.findAllByName(menuName);
                if(item.size() == 1){
                    prizeTotal = prizeTotal.add(item.get(0).getPrice());
                }
                else{
                    throw new MenuServiceException("Item not found in MenuItems",new Exception("Check Item"));
                }
            }
            orderEntity.setPriceAmount(prizeTotal);
            orderEntity.setTotalAmount(prizeTotal.add(orderEntity.getTaxAmount()));
            orderRepository.insert(orderEntity);
        }
        catch (Exception e){
            throw new OrderServiceException("Internal Server Error",e);
        }
        return true;
    }
}
