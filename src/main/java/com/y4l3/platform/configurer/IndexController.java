package com.y4l3.platform.configurer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.y4l3.platform.common.utils.StringUtils;
import com.y4l3.platform.module.common.CommonService;
import com.y4l3.platform.module.sys.entity.User;

/**
 * 首页信息控制层
 * @author changzhongq
 * @time 2018年11月12日 下午8:20:09
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/index";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUserId(StringUtils.getUUID());
			user.setUserName("test" + (i + 1));
			user.setLoginName("test" + (i + 1));
			user.setLoginPassword("test" + (i + 1));
			users.add(user);
		}
		CommonService.batchInsert(users.toArray());
	}
}
