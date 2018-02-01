package com.dawn.controller;

import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.SysUser;
import com.dawn.service.SysUserService;
import com.dawn.util.SnowflakeIdWorker;
import com.dawn.utils.ExcelUtil;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/uploadExcel/*")
public class UploadExcelController {
	@Autowired
	private SysUserService userService;

	/**
	 * 描述：通过传统方式form表单提交方式导入excel文件
	 *
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "upload", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8" )
	@ResponseBody
	public String uploadExcel(HttpServletRequest request, Model model) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		InputStream in = null;
		List<List<Object>> listob = null;
		MultipartFile file = multipartRequest.getFile("upfile");
		if (file.isEmpty()) {
			throw new Exception("文件不存在！");

		}
		in = file.getInputStream();
		listob = new ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		in.close();
		// 获取当前用户登录信息
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			SysUser vo = new SysUser();
			vo.setUsername(String.valueOf(lo.get(0)));
			// 雪崩算法获取盐值
			long salt = SnowflakeIdWorker.getInstance().nextId();
			// 获取密码 电话号码就是密码
			String pwd = String.valueOf(lo.get(1));
			// 密码 + 颜值
			String pwd_salt = pwd + salt;
			// 密码加密
			String pwd_salt_md = DigestUtils.md5DigestAsHex(pwd_salt.getBytes());

			vo.setUserPhone(String.valueOf(lo.get(1)));
			vo.setPassword(pwd_salt_md);
			vo.setParentId(activeUser.getUserid());// 只有老师可以导入该功能,老师的id为parentid
			vo.setSalt(String.valueOf(salt));// 保存盐值
			vo.setUserType(activeUser.getUser_type());// 老师是什么类型,导入学生就是什么类型
			vo.setLocked("1");// 0 停用 1.可用
			try {
				userService.excelUser(vo);
			}catch (MySQLIntegrityConstraintViolationException e){
				e.printStackTrace();

				return "数据库中已经有该用户信息"+vo.getUserPhone();
			}

		}
		//model.addAttribute("message", "导入成功!");
		return "导入成功!";
	}

	/**
	 * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 *//*
		 * @ResponseBody
		 *
		 * @RequestMapping(value = "/ajaxUpload.do", method = {
		 * RequestMethod.GET, RequestMethod.POST }) public void
		 * ajaxUploadExcel(HttpServletRequest request, HttpServletResponse
		 * response) throws Exception { MultipartHttpServletRequest
		 * multipartRequest = (MultipartHttpServletRequest) request;
		 *
		 * System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");
		 *
		 * InputStream in = null; List<List<Object>> listob = null;
		 * MultipartFile file = multipartRequest.getFile("upfile"); if
		 * (file.isEmpty()) { throw new Exception("文件不存在！"); }
		 *
		 * in = file.getInputStream(); listob = new
		 * ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		 *
		 * // 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出 for (int i = 0; i <
		 * listob.size(); i++) { List<Object> lo = listob.get(i); SysUser vo =
		 * new SysUser(); vo.setUsername(String.valueOf(lo.get(0)));
		 * vo.setPassword(String.valueOf(lo.get(1)));
		 * vo.setUserPhone(String.valueOf(lo.get(2)));
		 *
		 * System.out.println("打印信息-->用户:" + vo.getUsername() + "  名称：" +
		 * vo.getPassword() + "   电话：" + vo.getUserPhone() + "   密码：" +
		 * vo.getPassword()); }
		 *
		 * PrintWriter out = null; response.setCharacterEncoding("utf-8"); //
		 * 防止ajax接受到的中文信息乱码 out = response.getWriter(); out.print("文件导入成功！");
		 * out.flush(); out.close(); }
		 */

}