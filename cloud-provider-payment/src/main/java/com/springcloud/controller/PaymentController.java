package com.springcloud.controller;

import com.springcloud.entities.ComminResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuyang
 * @version 1.0
 * @date 2020/8/2 5:26 下午
 */
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public ComminResult create(Payment payment){
        int result = paymentService.create(payment);

        if (result > 0){
            return  new ComminResult(200,"插入数据成功",result);
        }else {
            return  new ComminResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get{id}")
    public ComminResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);

        if (result != null){
            return  new ComminResult(200,"查询成功",result);
        }else {
            return  new ComminResult(444,"无对应记录,查询ID：" + id,null);
        }
    }
}
