package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.dto.EmployeeDTO;
import com.example.RegisterLogin.dto.LoginDTO;
import com.example.RegisterLogin.payload.LoginMesage;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginMesage loginEmployee(LoginDTO loginDTO);

}
