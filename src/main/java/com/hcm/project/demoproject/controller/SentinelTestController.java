package com.hcm.project.demoproject.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hcm.project.demoproject.exception.ResException;
import com.hcm.project.demoproject.vo.ResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @description:
 * @author: josnhuang
 * @CodeReviewer: josnhuang
 * @CreateTime 2022/5/1 22:06
 */
@Slf4j
@RestController
public class SentinelTestController {
    Random random = new Random();

    @GetMapping("/apply")
    @SentinelResource(value = "/apply", blockHandler = "blockException", fallback = "fallException")
    public ResVO apply(String userId)throws Exception {
        int rt = random.nextInt(5);
        log.info("rt:{}", rt);
        Thread.sleep(rt*100L);
        if (rt > 2) {
//            throw new ResException("1003");
        }
        return ResVO.builder().resCode("200").resMsg("ok").build();
    }

    @GetMapping("/resend")
    @SentinelResource(value = "/resend", blockHandler = "blockException")
    public ResVO resend(String userId) {
        log.info("resend userId:{}", userId);
        return ResVO.builder().resCode("200").resMsg("ok").build();
    }

    public ResVO fallException(String userId, Throwable e) {
        if (e instanceof ResException) {
            log.error("响应超时", e);
        }
        log.info("{}被降级了", userId);
        return ResVO.builder().resMsg(userId + "被降级").resCode("1002").build();
    }

    public ResVO blockException(String userId, BlockException e) {
        return ResVO.builder().resMsg(userId + "被限流了").resCode("1001").build();
    }
}
