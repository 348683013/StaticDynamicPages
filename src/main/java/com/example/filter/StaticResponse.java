package com.example.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * author:zhouzhongzhong
 * date:2021/12/13,16:41
 */
public class StaticResponse extends HttpServletResponseWrapper {
    private HttpServletResponse response;
    private PrintWriter pw;
    public StaticResponse(HttpServletResponse response,String path) throws FileNotFoundException, UnsupportedEncodingException {
        super(response);
        this.response = response;
        //创建一个与html文件路径绑定在一起的流对象
        pw = new PrintWriter(path, "utf-8");
    }
    public PrintWriter getWriter() {
        //返回一个与html绑定在一起的printWriter对象
        //jsp会使用它进行输出，这样数据都输出到html文件中
        return pw;
    }
}
