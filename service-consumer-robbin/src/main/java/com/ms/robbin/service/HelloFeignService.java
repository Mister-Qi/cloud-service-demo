package com.ms.robbin.service;

import com.ms.robbin.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * When we add a @EnableFeignClients configuration at the entry of our program, the scanning for
 * @FeignClient will be turn on, user need define their interface with the particular Feign client develop specification.
 *
 * during program setup, it will scan all class annotated with @FeignClient and inject them into spring container,
 * while these class be invoked, spring will create proxy RestTemplate for each method call. the proxy will include all
 * necessary information for the remote call.
 *
 * If a robbin was introduced, the client will go on encapsulating into LoadBalancerClient for Robbin.
 *
 * @author Qi Qi
 * @version 1.0
 * @created 2020-06-21
 */
@FeignClient(name="SERVICE-PROVIDER")
public interface HelloFeignService {

    @RequestMapping(value="/user/find/{id}",method = RequestMethod.GET)
    User findUser(@PathVariable long id);
}
