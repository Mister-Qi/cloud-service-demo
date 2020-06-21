package com.qq.cloud.microservicecloudclient.controller;

import com.qq.cloud.microservicecloudclient.entity.User;
import com.qq.cloud.microservicecloudclient.service.HelloFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 常用注解说明
 *
 * swagger 通过注解接口生成文档，包括接口名，请求方法，参数，返回信息等。
 *
 * @Api: 修饰整个类，用于controller类上
 *
 * @ApiOperation: 描述一个接口，用户controller方法上
 *
 * @ApiParam: 单个参数描述
 *
 * @ApiModel: 用来对象接收参数, 即返回对象
 *
 * @ApiModelProperty: 对象接收参数时，描述对象的字段
 *
 * @ApiResponse: Http响应其中的描述，在ApiResonse中
 *
 * @ApiResponses: Http响应所有的描述
 *
 * @ApiIgnore: 忽略这个API
 *
 * @ApiError: 发生错误的返回信息
 *
 * @ApiImplicitParam: 一个请求参数
 *
 * @ApiImplicitParam: 多个请求参数
 */
@Api("The basic service api.") // the api class desc
@RestController
@RequestMapping("/service")
@Slf4j
public class ServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value ="the test method desc.",notes = "the test method notes..")
    @GetMapping("/test")
    public String test(){
        return "This is a test....";
    }

    @ApiOperation(value="the query user method desc.",notes="the query user method notes..")
    @GetMapping("/find/{id}")
    @ResponseBody
    public User findUser(
            @ApiParam(value="the user unique id",required = true)
            @PathVariable long id){
       return this.restTemplate.getForObject("http://service-provider/user/find/{id}", User.class, id);
    }

    @Autowired
    private HelloFeignService helloFeignService;

    @ApiOperation(value="the feign client query user method desc.", notes="the query user method notes...")
    @GetMapping("/find/feign/{id}")
    @ResponseBody // can user it at the class level, to avoid add it at every method.
    public User feignFindUser(@PathVariable long id){
        log.info("execute feign client findUser method.");
        return helloFeignService.findUser(id);
    }
}
