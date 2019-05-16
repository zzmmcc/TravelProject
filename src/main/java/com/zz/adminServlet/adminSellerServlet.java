package com.zz.adminServlet;

import com.zz.bean.Seller;
import com.zz.filter.MyLoginFilter;
import com.zz.service.Impl.SellerServiceImpl;
import com.zz.service.SellerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "adminSellerServlet",value = "/adminSellerServlet")
public class adminSellerServlet extends HttpServlet {
    SellerService sellerService = new SellerServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyLoginFilter.filterAdmin(request,response);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        if(method.equals("getSellerList")){
            getSellerList(request,response);
        }else if(method.equals("getSellerBySid")){
            getSellerBySid(request,response);
        }else if(method.equals("editSellerBySeller")){
            editSellerBySeller(request,response);
        }else if(method.equals("delSellerBySid")){
            delSellerBySid(request,response);
        }else if(method.equals("addSellerBySeller")){
            addSellerBySeller(request,response);
        }
    }

    private void addSellerBySeller(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Seller seller = new Seller();
        seller.setConsphone(request.getParameter("consphone"));
        seller.setAddress(request.getParameter("address"));
        seller.setSname(request.getParameter("sname"));
        int i = sellerService.addSellerBySeller(seller);
        response.getWriter().print(i);
    }

    public void delSellerBySid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        int i = sellerService.delSellerBySid(sid);
        response.getWriter().print(i);
    }

    public void editSellerBySeller(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Seller seller = new Seller();
        seller.setSid(Integer.parseInt(request.getParameter("sid")));
        seller.setConsphone(request.getParameter("consphone"));
        seller.setAddress(request.getParameter("address"));
        seller.setSname(request.getParameter("sname"));
        int i =sellerService.editSellerBySeller(seller);
        response.getWriter().print(i);
    }

    public void getSellerBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        Seller seller = sellerService.getSellerBySid(sid);
        request.setAttribute("seller",seller);
        request.getRequestDispatcher("admin/edit_seller.jsp").forward(request,response);
    }

    public void getSellerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Seller> list = sellerService.getSellerList();
        request.setAttribute("sellerList",list);
        request.getRequestDispatcher("admin/seller_list.jsp").forward(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
