package project.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dto.SpendingDto;
import project.entity.Income;
import project.entity.Spending;
import project.service.SpendingService;
import project.service.impl.SpendingServiceImpl;

@WebServlet("/spending")
public class SpendingController extends HttpServlet {
    private final SpendingService spendingService = new SpendingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("/price");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Spending spending = new Spending();
        spending.setMoney(Double.valueOf(request.getParameter("money")));
        spending.setLocalDate(LocalDate.parse(request.getParameter("localDate")));
        spendingService.add(spending);
        response.sendRedirect("/spending");
    }
}
