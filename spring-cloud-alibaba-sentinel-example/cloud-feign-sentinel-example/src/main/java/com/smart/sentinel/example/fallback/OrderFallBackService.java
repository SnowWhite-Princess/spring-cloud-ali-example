package com.smart.sentinel.example.fallback;

import com.smart.sentinel.example.domian.common.RespCode;
import com.smart.sentinel.example.domian.common.RespEntity;
import com.smart.sentinel.example.domian.dto.OrderDto;
import com.smart.sentinel.example.domian.dto.request.OrderRequestParams;
import com.smart.sentinel.example.service.OrderService;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

/**
 * 返回到客服端  封装通用的结果
 */
@Component
public class OrderFallBackService implements OrderService {
    @Override
    public RespEntity<List<OrderDto>> getOrderData(int uid, int page, int size) {
        // 暂无数据
        return RespEntity.success(new ArrayList<>());
    }

    /**
     * 直接返回错误信息
     *
     * @param requestParams
     * @return
     */
    @Override
    public String createOrder(OrderRequestParams requestParams) {
        return "调用失败!! 请稍后在试";
    }
}
