package com.windypath.lolstat.config.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

import com.google.common.collect.Sets;
import com.windypath.lolstat.modules.main.common.RequestHolder;
import com.windypath.lolstat.modules.main.vo.SysUserVo;

/**
 * 请求过滤器
 *
 * @author 乔纳森先生
 * @description RequestFilter
 * @date 2020/1/30 22:04
 */
@WebFilter(filterName = "RequestFilter", urlPatterns = "/*")
public class RequestFilter implements Filter {
    private static Set<String> URL_WHITE_LIST = Sets.newHashSet();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        URL_WHITE_LIST.add("/hello");
        URL_WHITE_LIST.add("/admin/login");
        URL_WHITE_LIST.add("/websocket");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestUrl = request.getRequestURI();
        for(String url: URL_WHITE_LIST) {
            if (requestUrl.contains(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        HttpSession session = request.getSession();
        // TODO 这个session装的user不知道从哪来，需要配合前端项目查看
        SysUserVo userVo = (SysUserVo) request.getSession().getAttribute("user");
        if (userVo == null) {
            request.getRequestDispatcher("/unauth").forward(request, response);
            return;
        }
        RequestHolder.add(userVo);
        RequestHolder.add(request);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
