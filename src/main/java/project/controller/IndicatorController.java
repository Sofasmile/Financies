//package project.controller;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import mate.academy.spring.entity.Indicator;
//import mate.academy.spring.service.IndicatorService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import project.entity.Income;
//import project.entity.Indicator;
//import project.service.IndicatorService;
//import project.service.impl.IndicatorServiceImpl;
//
//@WebServlet("/indicate")
//public class IndicatorController extends HttpServlet {
//    private final IndicatorService indicatorService = new IndicatorServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        return priceController.getAllInCome();
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        Indicator indicator = new Indicator();
//        indicator.setData1(Integer.valueOf(request.getParameter("data1")));
//        indicator.setData2(request.getParameter("data2"));
//        indicatorService.add(indicator);
//        response.sendRedirect("/income");
//    }
//
//
//
//    @PostMapping
//    public String submit(@ModelAttribute("indicate") Indicator indicator, ModelMap model) {
//        indicatorService.add(indicator);
////        model.addAttribute("data1", indicator.getData1());
////        model.addAttribute("data2", indicator.getData2());
//        return "menu";
//    }
//
//    @GetMapping
//    public ModelAndView showForm() {
//        return new ModelAndView("indicator", "indicate", new Indicator());
//    }
//}
