package com.hcl.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    byte[] invoiceByOrderId(
            HttpServletRequest request,
            HttpServletResponse response,
            Long orderId
    );
}
