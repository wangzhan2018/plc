package cn.lylg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

/**
 * Created by wangzhan on 2018-03-27.
 */
@Controller
public class TextController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }


}
