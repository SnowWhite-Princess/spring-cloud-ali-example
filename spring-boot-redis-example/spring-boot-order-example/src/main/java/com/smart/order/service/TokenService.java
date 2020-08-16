package com.smart.order.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TokenService {

    String createToken();

    boolean checkToken(HttpServletRequest request);


}
