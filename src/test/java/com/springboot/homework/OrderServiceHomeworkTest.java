package com.springboot.homework;

import com.springboot.exception.BusinessLogicException;
import com.springboot.member.entity.Member;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import com.springboot.order.repository.OrderRepository;
import com.springboot.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderServiceHomeworkTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void cancelOrderTest() {
        // TODO OrderService의 cancelOrder() 메서드를 테스트하는 테스트 케이스를 여기에 작성하세요.
        // TODO Mockito를 사용해야 합니다. ^^
        // given
        long orderId = 1L;

        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(Order.OrderStatus.ORDER_CONFIRM);

        given(orderRepository.findById(Mockito.anyLong())).willReturn(Optional.of(order));

        // when, then
        assertThrows(BusinessLogicException.class, () -> orderService.cancelOrder(orderId));


    }
}
