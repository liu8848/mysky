package com.sky.controller.admin;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Tag(name = "员工相关服务")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    @Operation(summary = "员工登陆方法")
    @ApiOperationSupport(author = "qzliu")
    public Result<EmployeeLoginVO> login(@RequestBody
                                          @Parameter(name = "登陆传输的用户数据格式")
                                             EmployeeLoginDTO employeeLoginDTO){
        log.info("员工登陆：{}",employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //生成jwt令牌
        Map<String,Object> claims=new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID,employee.getId());
        String token= JwtUtil.createJWT(jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(), claims);

        EmployeeLoginVO employeeLoginVO=EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();
        return Result.success(employeeLoginVO);

    }

    @PostMapping("/logout")
    public Result<String> logout(){
        return Result.success();
    }


    @PostMapping
    @ApiOperationSupport(author = "qzliu")
    @Operation(summary = "添加员工")
    public Result addEmployee(@RequestBody
                                      @Parameter(name = "新增的用户信息对象")
                                      EmployeeDTO employeeDTO){

        employeeService.addEmployee(employeeDTO);
        return Result.success();
    }
}
