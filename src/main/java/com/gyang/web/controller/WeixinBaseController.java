package com.gyang.web.controller;

import com.gyang.db.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gyang on 16-4-1.
 */
@Controller
public class WeixinBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeixinBaseController.class);

    @RequestMapping(value = "/valid.do")
    public void getMaxId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        LOGGER.info("收到微信请求, signature = {}, timestamp = {}, nonce = {}, echostr = {}.", new Object[]{signature, timestamp, nonce, echostr});

        response.getWriter().write(echostr);
        response.getWriter().flush();
    }
}
