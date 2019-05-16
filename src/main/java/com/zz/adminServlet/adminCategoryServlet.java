package com.zz.adminServlet;

import com.zz.bean.Category;
import com.zz.filter.MyLoginFilter;
import com.zz.service.CategoryService;
import com.zz.service.Impl.CategoryServiceImpl;
import com.zz.util.JedisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "adminCategoryServlet",value = "/adminCategoryServlet")
public class adminCategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         MyLoginFilter.filterAdmin(request, response);
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            String method = request.getParameter("method");
           if(method.equals("getCategoryBySort")){
                getCategoryBySort(request,response);
            }else if(method.equals("addCategory")){
                addCategory(request,response);
            }else if(method.equals("delCategoryByCid")){
                delCategoryByCid(request,response);
            }else if(method.equals("getCategoryByCid")){
                getCategoryByCid(request,response);
            }else if(method.equals("editCategoryByCate")){
                editCategoryByCate(request,response);
            }
        }



    public void editCategoryByCate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        Category category = new Category(cid,cname);
        int i = categoryService.editCategoryByCate(category);
        if(i==1){
            JedisUtil.getJedis().del("category");
        }
        response.getWriter().print(i);
    }

    public void getCategoryByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        Category category = categoryService.getCategoryByCid(cid);
        request.setAttribute("category",category);
        request.getRequestDispatcher("admin/edit_category.jsp").forward(request,response);
    }

    public void delCategoryByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int i = categoryService.delCategoryByCid(cid);
        String msg ="";
        if(i==0){
            msg = "移除失败，有数据依赖此分类，不可被移除！";
        }else {
            JedisUtil.getJedis().del("category");
            msg = "移除成功！";
        }
        response.getWriter().print(msg);
    }

    public void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cname = request.getParameter("cname");
        int i = categoryService.addCategory(cname);
        if(i==1){
            JedisUtil.getJedis().del("category");
        }
        response.getWriter().print(i);
    }

    public void getCategoryBySort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ArrayList<Category> list = categoryService.getCategoryBySort();
            request.setAttribute("cateList",list);
            request.getRequestDispatcher("admin/route_category.jsp").forward(request,response);
    }

}
