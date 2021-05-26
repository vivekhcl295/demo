package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    private OrderService orderService;
    private ServletContext servletContext;
    private TemplateEngine templateEngine;

    @Autowired
    public PdfServiceImpl(
            OrderService orderService,
            ServletContext servletContext,
            TemplateEngine templateEngine
    ) {
        this.orderService = orderService;
        this.servletContext = servletContext;
        this.templateEngine = templateEngine;
    }

    public byte[] invoiceByOrderId(
            HttpServletRequest request,
            HttpServletResponse response,
            Long orderId
    ) {

        Order order = orderService.findOrderByOrderId(orderId);

        /* Create HTML using Thymeleaf template Engine */
        WebContext context = new WebContext(request, response, servletContext);
        context.setVariable("orderEntry", order);

        String orderHtml = templateEngine.process("order", context);

        /* Setup Source and target I/O streams */

        ByteArrayOutputStream target = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(orderHtml, target);

        /* extract output as bytes */
        byte[] bytes = target.toByteArray();

        return bytes;
    }
}
