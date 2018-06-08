package org.slh.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: FormController
 * @Description: 动态页面跳转
 * @author Song
 *
 */
@Controller
public class FormController {

	@RequestMapping(value = "/{formName}")
	public String loginForm(@PathVariable String formName) {
		// 动态跳转页面

		return formName;
	}

}
