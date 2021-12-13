package com.example.filter;
/**
 * 页面静态化
 * author:zhouzhongzhong
 * date:2021/12/13,16:00
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class UserFilter implements Filter {
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String name = request.getParameter("name");
        String htmlPage = name + ".html";//生成对应文件用的名称
        String htmlPath = config.getServletContext().getRealPath("/htmls");//对应文件的存放路径
        File destFile = new File(htmlPath, htmlPage);

        if (destFile.exists()) {
            //静态页面存在重定向到这个页面
            resp.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
            return;
        }

        //掉包response，让它的getWriter()和一个html文件绑定，让show.jsp内容输出到html页面中
        StaticResponse sr = new StaticResponse(resp, destFile.getAbsolutePath());
        chain.doFilter(request, sr);//放行
        //页面已经存在，重定向到html文件
        resp.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
    }
}
