package project.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.entity.Income;
import project.entity.Spending;
import project.service.IncomeService;
import project.service.PriceService;
import project.service.SpendingService;
import project.service.impl.IncomeServiceImpl;
import project.service.impl.PriceServiceImpl;
import project.service.impl.SpendingServiceImpl;

@WebServlet("/price")
public class PriceController extends HttpServlet {
    private final PriceService priceService = new PriceServiceImpl();
    private final IncomeService incomeService = new IncomeServiceImpl();
    private final SpendingService spendingService = new SpendingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Income> incomes = incomeService.getAll();
        List<Spending> spendings = spendingService.getAll();
        request.setAttribute("incomes", incomes);
        request.setAttribute("spending", spendings);
        request.getRequestDispatcher("/price.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Double nvp = priceService.countNvp(Integer.valueOf(request.getParameter("discountRate")));
        List<Income> incomes = incomeService.getAll();
        List<Spending> spendings = spendingService.getAll();
        request.setAttribute("message", nvp);
        request.setAttribute("incomes", incomes);
        request.setAttribute("spending", spendings);
        request.getRequestDispatcher("/price.jsp").forward(request, response);
    }
}
