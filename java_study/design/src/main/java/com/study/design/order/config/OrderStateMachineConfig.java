package com.study.design.order.config;

import com.study.design.order.pojo.Order;
import com.study.design.order.pojo.OrderState;
import com.study.design.order.pojo.OrderStateChangeAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

@Configuration
@EnableStateMachine(name="orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderStateChangeAction> {
    public void configure(StateMachineStateConfigurer<OrderState, OrderStateChangeAction> states) throws Exception {
        states.withStates().initial(OrderState.ORDER_WAIT_PAY)
                .states(EnumSet.allOf(OrderState.class));
    }

    public void configure(StateMachineTransitionConfigurer<OrderState, OrderStateChangeAction> transitions) throws Exception {
        transitions.withExternal().source(OrderState.ORDER_WAIT_PAY)
                .target(OrderState.ORDER_WAIT_SEND)
                .event(OrderStateChangeAction.PAY_ORDER)
                .and()
                .withExternal().source(OrderState.ORDER_WAIT_SEND)
                .target(OrderState.ORDER_WAIT_RECEIVE)
                .event(OrderStateChangeAction.SEND_ORDER)
                .and()
                .withExternal().source(OrderState.ORDER_WAIT_RECEIVE)
                .target(OrderState.ORDER_FINISH)
                .event(OrderStateChangeAction.RECEIVE_ORDER);
    }

    // ????????????????????????
    @Bean
    public DefaultStateMachinePersister machinePersister() {
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object, Object, Order>() {

            @Override
            public void write(StateMachineContext<Object, Object> stateMachineContext, Order order) throws Exception {
                //????????????????????????????????????????????????????????????redis ??? mongodb???mysql???ecache
            }

            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                // ???????????????????????????????????????????????????????????????????????????
                return new DefaultStateMachineContext(order.getOrderState(), null, null, null);
            }
        });
    }
}
