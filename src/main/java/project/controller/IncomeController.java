package project.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.entity.Income;
import project.service.IncomeService;
import project.service.impl.IncomeServiceImpl;

@WebServlet("/income")
public class IncomeController extends HttpServlet {
    private final IncomeService incomeService = new IncomeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("/price");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Income income = new Income();
        income.setMoney(Double.valueOf(request.getParameter("money")));
        income.setLocalDate(LocalDate.parse(request.getParameter("localDate")));
        incomeService.add(income);
        response.sendRedirect("/income");
    }
}
