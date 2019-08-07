package com.zz.adminServlet;

import com.zz.bean.*;
import com.zz.filter.MyLoginFilter;
import com.zz.service.*;
import com.zz.service.Impl.*;
import com.zz.util.FileUtils;
import com.zz.util.PageUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@WebServlet(name = "adminRouteServlet", value = "/adminRouteServlet")
public class adminRouteServlet extends HttpServlet {
    RouteService routeService = new RouteServiceImpl();
    RouteImgService routeImgService = new RouteImgServiceImpl();
    FavoriteService favoriteService = new FavoriteServiceImpl();
    SellerService sellerService = new SellerServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyLoginFilter.filterAdmin(request, response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if (method.equals("getRouteListBySearch_textWithPage")) {
            getRouteListBySearch_textWithPage(request, response);
        } else if (method.equals("getRouteForEditByRid")) {
            getRouteForEditByRid(request, response);
        } else if (method.equals("delRouteByRid")) {
            delRouteByRid(request, response);
        } else if (method.equals("delRoutesByRids")) {
            delRoutesByRids(request, response);
        } else if (method.equals("submitRouteMsg")) {
            submitRouteMsg(request, response);
        } else if (method.equals("addRouteUI")) {
            addRouteUI(request, response);
        } else if (method.equals("addRouteByRoute")) {
            addRouteByRoute(request, response);
        } else if (method.equals("getRouteImgByRid")) {
            getRouteImgByRid(request, response);
        } else if (method.equals("upPic")) {
            upPic(request, response);
        } else {
            System.out.println(method);
            response.getWriter().print("请求不存在");
        }
    }

    public void upPic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        //建立上传的核心对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //建立上传对象
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //防止乱码
        fileUpload.setHeaderEncoding("utf-8");
        //设置文件大小
        fileUpload.setFileSizeMax(1024 * 1024 * 10);

        List<FileItem> list = null;
        try {
            list = fileUpload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String smallpic = "";
        String bigpic = "";
        String rimage = "";
        for (int i = 0; i < list.size(); i++) {
            FileItem item = list.get(i);
            String filename = item.getName();
            filename = FileUtils.getRealFileName(filename);
            filename = "m" + FileUtils.getUUIDFileName(filename);
            if (i == 0) {
                //缩略图
                String path = "H:\\Resource2.26\\TravelProject\\src\\main\\webapp\\img\\product\\small";
                rimage = "img/product/small/" + filename;
                savePic(path, item, filename);
                //小图
                smallpic = "img/product/size2/" + filename;
                path = "H:\\Resource2.26\\TravelProject\\src\\main\\webapp\\img\\product\\size2";
                savePic(path, item, filename);
            } else if (i == 1) {
                //大图
                String path = "H:\\Resource2.26\\TravelProject\\src\\main\\webapp\\img\\product\\size4";
                bigpic = "img/product/size4/" + filename;
                savePic(path, item, filename);
            }
        }
        routeService.addRimageByRid(rid, rimage);
        routeImgService.addRouteImgByRid(rid, smallpic, bigpic);
        System.out.println(rid);
        response.getWriter().print("<script type='text/javascript'>window.onload=function(){window.location.href='/TravelProject/adminRouteServlet?method=getRouteImgByRid&rid=" + rid + "'}</script>");
    }

    public void savePic(String path, FileItem item, String filename) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            InputStream in = item.getInputStream();
            path = path + File.separator + filename;
            FileOutputStream outputStream = new FileOutputStream(path);
            IOUtils.copy(in, outputStream);
            outputStream.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getRouteImgByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        Route r = routeService.getRouteByRid(rid);
        //获取routeimg
        ArrayList<RouteImg> routeImg = routeImgService.getRouteImgByRid(rid);
        RouteMsg routeMsg = new RouteMsg(r, routeImg, null, null, null, null);
        request.setAttribute("routeMsg", routeMsg);
        request.getRequestDispatcher("admin/edit_routeImg.jsp").forward(request, response);
    }

    public void addRouteByRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String rname = request.getParameter("rname");
        int cid = Integer.parseInt(request.getParameter("cname"));
        double price = Double.parseDouble(request.getParameter("price"));
        String rdate = request.getParameter("rdate");
        String sourceId = request.getParameter("sourceId");
        String rflag = "0";
        String[] rflags = request.getParameterValues("rflag");
        if (null != rflags) {
            rflag = "1";
        }
        String tour = "0";
        String[] tours = request.getParameterValues("tour");
        if (null != tours) {
            tour = "1";
        }
        String routeintroduce = request.getParameter("routeintroduce");
        Route route = new Route();
        route.setCid(cid);
        route.setRname(rname);
        route.setSid(sid);
        route.setPrice(price);
        route.setRdate(rdate);
        route.setRflag(rflag);
        route.setIsthemetour(tour);
        route.setSourceid(sourceId);
        route.setRouteintroduce(routeintroduce);
        int rid = routeService.addRouteByRoute(route);
        Route r = routeService.getRouteByRid(rid);
        //获取routeimg
        ArrayList<RouteImg> routeImg = routeImgService.getRouteImgByRid(rid);
        RouteMsg routeMsg = new RouteMsg(r, routeImg, null, null, null, null);
        request.setAttribute("routeMsg", routeMsg);
        request.getRequestDispatcher("admin/edit_routeImg.jsp").forward(request, response);
    }

    public void addRouteUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categoryList = categoryService.getCategory();
        ArrayList<Seller> sellerList = sellerService.getSellerList();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("sellerList", sellerList);
        request.getRequestDispatcher("admin/add_route.jsp").forward(request, response);
    }

    public void submitRouteMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        String rname = request.getParameter("rname");
        int cid = Integer.parseInt(request.getParameter("cname"));
        double price = Double.parseDouble(request.getParameter("price"));
        String rdate = request.getParameter("rdate");
        String rflag = "0";
        String[] rflags = request.getParameterValues("rflag");
        if (null != rflags) {
            rflag = "1";
        }
        String tour = "0";
        String[] tours = request.getParameterValues("tour");
        if (null != tours) {
            tour = "1";
        }
        String routeintroduce = request.getParameter("routeintroduce");
        Route route = new Route();
        route.setRdate(rdate);
        route.setCid(cid);
        route.setRname(rname);
        route.setRid(rid);
        route.setPrice(price);
        route.setRflag(rflag);
        route.setIsthemetour(tour);
        route.setRouteintroduce(routeintroduce);
        routeService.submitRouteMsg(route);
        getRouteForEditByRid(request, response);
    }

    public void delRoutesByRids(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] checkIds = request.getParameterValues("checkId");
        String[] split = checkIds[0].split(",");
        int rids[] = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            rids[i] = Integer.parseInt(split[i]);
        }
        routeService.delRouteByRids(rids);
        getRouteListBySearch_textWithPage(request, response);

    }

    public void delRouteByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        routeService.delRouteByRid(rid);
        getRouteListBySearch_textWithPage(request, response);
    }

    public void getRouteForEditByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        //获取route
        Route route = routeService.getRouteByRid(rid);
        //获取routeimg
        ArrayList<RouteImg> routeImg = routeImgService.getRouteImgByRid(rid);
        //获取favorite
        User user = (User) request.getSession().getAttribute("loginUser");
        Favorite favorite = null;
        if (user == null || user.equals("")) {
            favorite = favoriteService.getFavoriteByRid(rid);
        } else {
            favorite = favoriteService.getFavoriteByRid_Uid(rid, user.getUid());
        }
        //获取seller
        Seller seller = sellerService.getSellerBySid(route.getSid());
        //获取category
        Category category = categoryService.getCategoryByCid(route.getCid());

        RouteMsg routeMsg = new RouteMsg(route, routeImg, favorite, seller, null, category);

        ArrayList<Category> cate = categoryService.getCategory();
        request.setAttribute("cateList", cate);
        request.setAttribute("routeMsg", routeMsg);
        request.getRequestDispatcher("admin/edit_route.jsp").forward(request, response);
    }

    public void getRouteListBySearch_textWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search_text = request.getParameter("search_text");
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int pageSize = 16;
        PageUtil<Route> pageList = routeService.getRouteListBySearch_textWithPage(pageNow, pageSize, search_text);
        ArrayList<Category> cate = categoryService.getCategory();
        request.setAttribute("search_text", search_text);
        request.setAttribute("cateList", cate);
        request.setAttribute("pageList", pageList);
        request.getRequestDispatcher("admin/route_list.jsp").forward(request, response);
    }


}
