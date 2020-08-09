package com.smart.order.service.impl;

import com.smart.order.domain.dto.*;
import com.smart.order.domain.dto.request.OrderRequestParams;
import com.smart.order.domain.entity.Order;
import com.smart.order.domain.entity.OrderAddress;
import com.smart.order.domain.entity.OrderItem;
import com.smart.order.mapper.TbOrderAddressMapper;
import com.smart.order.mapper.TbOrderItemMapper;
import com.smart.order.mapper.TbOrderMapper;
import com.smart.order.service.OrderService;
import com.smart.order.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单单号
 * 标题 JD-订单号
 * 总金额
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Resource
    TbOrderMapper orderMapper;
    @Resource
    TbOrderItemMapper orderItemMapper;
    @Resource
    TbOrderAddressMapper orderAddressMapper;
    @Resource
    ProductService productService;

    @Override
    public PayDto createOrder(OrderRequestParams requestParams) {
        // 生成orderNo
        // 保存主表的数据
//        Order order = new Order();
//        Long uid = Long.valueOf(requestParams.getUid());
//        order.setOrderNo("123456");
//        order.setMemberId(uid);
////        保存 order-item
//        List<Integer> ids = requestParams.getIds();
//        List<ProductDto> list = productService.list(ids);
//        // 判断库存
//
//
//        orderMapper.insert(order);
//        //计算总金额    满减
//
//        // 保存 order-item
//        OrderItem orderItem = new OrderItem();
//        orderItem.setMemberId(uid);
//        orderItem.setOrderId(order.getOrderId());
//
//        // 保存配送的地址信息
//        OrderAddress orderAddress = new OrderAddress();
//        orderAddress.setAddress(requestParams.getAddress());
//        orderAddress.setPhone(requestParams.getPhone());


        //生成订单
        OrderDto orderDto = new OrderDto();
        Order order = new Order();
        orderDto.setOrderNo(requestParams.getOrderNo());
        orderDto.setTotal(requestParams.getTotal());
        orderDto.setMemberId(requestParams.getMemberId());
        BeanUtils.copyProperties(orderDto, order);
        orderMapper.insert(order);

        //生成订单详情
        OrderItemDto orderItemDto = new OrderItemDto();
        OrderItem orderItem = new OrderItem();
        orderItemDto.setOrderId(order.getOrderId());
        orderItemDto.setMemberId(order.getMemberId());
        orderItemDto.setProductPic(requestParams.getProductPic());
        orderItemDto.setProductName(requestParams.getProductName());
        orderItemDto.setProductPrice(requestParams.getTotal());
        orderItemDto.setProductQuantity(requestParams.getProductQuantity());
        BeanUtils.copyProperties(orderItemDto,orderItem);
        orderItemMapper.insert(orderItem);

        //保存配送的地址信息
        OrderAddressDto orderAddressDto = new OrderAddressDto();
        OrderAddress orderAddress = new OrderAddress();
        orderAddressDto.setAddress(requestParams.getAddress());
        orderAddressDto.setPhone(requestParams.getPhone());
        orderAddressDto.setOrderId(order.getOrderId());
        BeanUtils.copyProperties(orderAddressDto,orderAddress);
        orderAddressMapper.insert(orderAddress);


        //保存产品信息

        productService.createProduct(requestParams);

        // 返回给客服端数据
        PayDto payDto = new PayDto();
        payDto.setOrderNo(requestParams.getOrderNo());
        payDto.setSubject("xxx-" + "1234566");
        payDto.setTotal(requestParams.getTotal());
        payDto.setPayType(requestParams.getExpressType());
        return payDto;
    }

}
