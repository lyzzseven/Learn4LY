package com.springcloud.service.impl;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuyang
 * @version 1.0
 * @date 2020/8/2 5:19 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return  paymentDao.create(payment);
    }

    public Payment getPaymentById( Long id){
        return  paymentDao.getPaymentById(id);
    }
}
