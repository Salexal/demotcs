package com.example.demotcs.Controller;

import com.example.demotcs.entity.Msg;
import com.example.demotcs.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/14 15:39
 * @Version 1.0
 * @Type
 */
@Controller
public class indexController {




    @RequestMapping("/index")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
}
