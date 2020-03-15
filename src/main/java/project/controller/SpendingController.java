package project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.entity.Income;
import project.entity.Spending;
import project.service.IncomeService;
import project.service.SpendingService;
import project.service.impl.IncomeServiceImpl;
import project.service.impl.SpendingServiceImpl;

@WebServlet("/spending")
public class SpendingController extends HttpServlet {
    private final SpendingService spendingService = new SpendingServiceImpl();
    private final IncomeService incomeService = new IncomeServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("/price");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LocalDate localDate = null;
        List<Income> incomes = incomeService.getAll();
        List<Spending> spendings = spendingService.getAll();
        try {
            localDate = LocalDate.parse(request.getParameter("localDate"));
        }catch (Exception e){
            request.setAttribute("message2", "Data should have format yyyy-mm-dd");
            request.setAttribute("incomes", incomes);
            request.setAttribute("spending", spendings);
            request.getRequestDispatcher("/price.jsp").forward(request, response);
            return;
        }
        Spending spending = new Spending();
        spending.setMoney(Double.valueOf(request.getParameter("money")));
        spending.setLocalDate(localDate);
        spendingService.add(spending);
        response.sendRedirect("/spending");
    }
}
