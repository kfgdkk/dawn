package com.dawn.controller;

import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.TbTitle;
import com.dawn.pojo.TbTitleCustom;
import com.dawn.service.TbTitleService;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TbTitleController {
	@Autowired
	private TbTitleService titleService;

	/**
	 * 
	 * <p>
	 * Title: getTitleList
	 * </p>
	 * <p>
	 * Description:查询题目列表
	 * </p>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/title/list")
	@ResponseBody
	public Result getTitleList(@RequestParam(value = "categordId") Long categordId, int page, int rows) {

		return titleService.getTitleList1(categordId,page,rows);
	}

	/**
	 * 加载用户下的未审核、未通过的面试题
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/title/auditStatus")
	@ResponseBody
	public List auditStatus(Integer userid) {
		List<TbTitle> list = titleService.getTitleAuditList(userid);
		return list;
	}

	/**
	 * 跳转页面到
	 * 
	 * @return
	 */
	@RequestMapping("/title/toTitleStatus")
	public String toauditStatus3() {
		return "title_status";
	}

	@RequestMapping("/title/audits")
	public String toaudit() {
		return "title_audit";
	}

	/**
	 * 根据题目id 查询题目名称
	 * 
	 * @param tbtitleId
	 * @return
	 */
	@RequestMapping("/title/selectTitleById/{tbtitleId}")
	@ResponseBody
	public List selectTitleById(@PathVariable Long tbtitleId) {
		List list = new ArrayList();
		String title = titleService.selectTitleById(tbtitleId);
		list.add(title);
		return list;
	}

	/**
	 * 
	 * <p>
	 * Title: addTitle
	 * </p>
	 * <p>
	 * Description: 添加题目
	 * </p>
	 * 
	 * @param title
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/title/add", method = RequestMethod.POST)
	@ResponseBody
	public DawnResult addTitle(TbTitle title, String titleDesc, HttpServletRequest request) throws Exception {
		// 从session中获取登陆信息
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		Integer userType = 0;
		if (activeUser != null && activeUser.getUser_type() != 0) {
			userType = activeUser.getUser_type();
		}
		return titleService.saveTitle(title, titleDesc, userType, activeUser.getUserid());
	}

	//题目存在则删除  李先生
	@RequestMapping("/background/title/delete")
	@ResponseBody
	public DawnResult delTitle1(String ids) {
		// AuthPermission auth = new AuthPermission();

	/*	String ides = ids.substring(0, ids.length() - 1);*/
		String[] id = ids.split(",");

		/*
		 * boolean flag = false; for (int i = 0; i < id.length; i++) { flag =
		 * auth.authPermissionUserTitle(Long.valueOf(id[i]), request); }
		 */
		// 判断是否有权限操作
		// if (flag) {
		for (int i = 0; i < id.length; i++) {
//			titleService.updateStatu(Long.valueOf(id[i]));
			titleService.delTitle(Long.valueOf(id[i]));
			titleService.delDesc(Long.valueOf(id[i]));
		}
		return DawnResult.ok();
		// }
		// return DawnResult.build(400, "您无权操作此功能");
	}
	/**
	 *
	 * <p>
	 * Description: 批量审核通过题目 李先生
	 * </p>
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/background/title/updateAll")
	@ResponseBody
	public DawnResult delTitle(String ids) {
		// AuthPermission auth = new AuthPermission();

	/*	String ides = ids.substring(0, ids.length() - 1);*/
		String[] id = ids.split(",");

		/*
		 * boolean flag = false; for (int i = 0; i < id.length; i++) { flag =
		 * auth.authPermissionUserTitle(Long.valueOf(id[i]), request); }
		 */
		// 判断是否有权限操作
		// if (flag) {
		for (int i = 0; i < id.length; i++) {
			titleService.updateStatu(Long.valueOf(id[i]));
//			titleService.delTitle(Long.valueOf(id[i]));
//			titleService.delDesc(Long.valueOf(id[i]));
		}
		return DawnResult.ok();
		// }
		// return DawnResult.build(400, "您无权操作此功能");
	}

	//批量驳回 李先生
	@RequestMapping("/background/title/updateAllNo")
	@ResponseBody
	public DawnResult update(String ids,TbTitleCustom custom) {
		// AuthPermission auth = new AuthPermission();
		String cause = custom.getCause();
	/*	String ides = ids.substring(0, ids.length() - 1);*/
		String[] id = ids.split(",");

		/*
		 * boolean flag = false; for (int i = 0; i < id.length; i++) { flag =
		 * auth.authPermissionUserTitle(Long.valueOf(id[i]), request); }
		 */
		// 判断是否有权限操作
		// if (flag) {
		for (int i = 0; i < id.length; i++) {
			titleService.updateTbtitle(Long.valueOf(id[i]),cause);
//			titleService.delTitle(Long.valueOf(id[i]));
//			titleService.delDesc(Long.valueOf(id[i]));
		}
		return DawnResult.ok();
		// }
		// return DawnResult.build(400, "您无权操作此功能");
	}

	// 学生未通过的题目直接删除
	@RequestMapping("/title/deleteStudent")
	@ResponseBody
	public DawnResult delTitleStudent(String ids, HttpServletRequest request) {
		/*
		 * boolean flag = false; for (int i = 0; i < id.length; i++) { flag =
		 * auth.authPermissionUserTitle(Long.valueOf(id[i]), request); }
		 */
		// 判断是否有权限操作
		// if (flag) {
		titleService.delTitle(Long.valueOf(ids));
		titleService.delDesc(Long.valueOf(ids));
		return DawnResult.ok();
		// }
		// return DawnResult.build(400, "您无权操作此功能");
	}

	// 题目和答案的修改
	@RequestMapping(value = "/title/update", method = RequestMethod.POST)
	@ResponseBody
	public DawnResult updateTitle(TbTitle title, String titleDesc, HttpServletRequest request) throws Exception {
		titleService.updateTitle(title, titleDesc);
		return DawnResult.ok();
	}

	// 学生审核未通过后修改题目和答案的修改
	@RequestMapping(value = "/title/updateStudent", method = RequestMethod.POST)
	@ResponseBody
	public DawnResult updateTitles(TbTitle title, String titleDesc, HttpServletRequest request) throws Exception {

		titleService.updateTitle(title, titleDesc);
		return DawnResult.ok();

	}

	// 根据知识点名称进行模糊查询
	@RequestMapping("/title/like/{categoryId}")
	@ResponseBody
	public Result queryLike(int page, int rows, @PathVariable String categoryId, HttpServletRequest request) {
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		Integer userType = activeUser.getUser_type();// 用户类型
		try {
			categoryId = new String(categoryId.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Result results = titleService.getByName(categoryId, page, rows, userType);
		return results;
	}

	// 分页查询我的审核  李先生
	@RequestMapping("/background/title/audit")
	@ResponseBody
	public Result findPage(HttpServletRequest request,int page, int rows) {
		ActiveUser user = (ActiveUser) request.getSession().getAttribute("activeUser");
		Result result = titleService.findPage(page,rows,user.getUserid());

		return result;
	}

	// 通过，根据题目id修改审核状态码，并刷新当前页面。 李先生
	@RequestMapping("/background/title/updateStatu")
	@ResponseBody
	public DawnResult updateStatu(@Param("id") long tbtitleId) {
		titleService.updateStatu(tbtitleId);
		return DawnResult.ok();
	}

	// 未通过，驳回请求并给出原因   李先生
	@RequestMapping("/background/title/updated")
	@ResponseBody
	public DawnResult updateTbtitle(@Param("id") long tbtitleId, TbTitleCustom custom) {
		String cause = custom.getCause();
		if (cause.equals("3")) {
			// 已有该知识点执行删除。
			delTitle1(String.valueOf(tbtitleId));
		} else {
			titleService.updateTbtitle(tbtitleId, cause);
		}
		return DawnResult.ok();
	}

}
