package com.y4l3.platform.module.sys.controller;

import com.y4l3.platform.common.base.BaseController;
import com.y4l3.platform.common.message.ResponseResult;
import com.y4l3.platform.module.sys.entity.Phonogram;
import com.y4l3.platform.module.sys.service.PhonogramService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kay
 * @version 1.0 2020/2/15
 */
@Controller
@RequestMapping("/app")
public class ApplicationController extends BaseController<Phonogram, PhonogramService> {
    private static final String PATH_PREFIX = "/module/sys/app/";

    @RequestMapping(value = "/phonogramPage", method = RequestMethod.GET)
    public String roleListPage() {
        return PATH_PREFIX + "phonogramList";
    }

    @RequestMapping(value = "/phonetics", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult phonetics() {
        return ResponseResult.ok(service.getPhonetics());
    }
}
