package com.zz.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "checkServlet", value = "/checkcode")
public class checkServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        check(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void t() {
        String r = radom();
        System.out.println(r);
    }

    public String radom() {
        Random r = new Random();
        String str = "";
        //定义变量拼接随机生成的验证码 a-z A-Z 0-9
        //循环4次，目的生成4个随机字符
        for (int i = 1; i <= 4; i++) {
            switch (r.nextInt(3)) {
                case 0:
                    str += (char) (r.nextInt(26) + 97);
                    break;
                case 1:
                    str += (char) (r.nextInt(26) + 65);
                    break;
                case 2:
                    str += r.nextInt(10);
                    break;
            }
        }
        return str;
    }

    public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用BufferedImage制作画布,传入三个参数：长、宽、？
        BufferedImage bufferedImage = new BufferedImage(150, 40, BufferedImage.TYPE_INT_BGR);
        //根据画布对象获取画笔
        Graphics pen = bufferedImage.getGraphics();
        //设置画笔的起始位置以及范围大小
        pen.drawRect(0, 0, 150, 40);
        pen.setColor(Color.GRAY);   //设置填充颜色
        pen.fillRect(0, 0, 150, 40);   //起始X坐标，起始Y坐标，宽度，高度。
        //定义变量拼接随机生成的验证码 a-z A-Z 0-9
        //循环4次，目的生成4个随机字符
        String str = radom();
        pen.setColor(Color.BLACK);
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            pen.drawString(".", r.nextInt(150), r.nextInt(40));
        }
        pen.setColor(Color.white);
        pen.setFont(new Font("宋体", Font.BOLD, 20));
        pen.drawString(str, 70, 18);
        request.getSession().setAttribute("checkStr", str);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(bufferedImage, "png", outputStream);
    }
}
