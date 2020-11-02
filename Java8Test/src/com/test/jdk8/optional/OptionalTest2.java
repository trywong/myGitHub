package com.test.jdk8.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.test.jdk8.bean.Company;
import com.test.jdk8.bean.Employee;

public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");

        List<Employee> employees = Arrays.asList(employee, employee2);
        company.setEmployee(employees);

        // 需求：如果company里面的employee不为空，就返回这个employee列表，如果为空的话就构建一个空的List<Employee>对象回来
        Optional<Company> optional = Optional.ofNullable(company);
        // map方法把一个值映射成另一个值。一个应用lambda表达式的比较复杂的示例，但是又是经常用到的一种写法。很漂亮的代码
        System.out.println(optional.map(theCompany -> theCompany.getEmployee()).orElse(Collections.emptyList()));
    }
}
