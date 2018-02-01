package com.dawn.controller;

import com.dawn.pojo.TbCategory;
import com.dawn.pojo.TbTitle;
import com.dawn.service.TbCategoryService;
import com.dawn.service.TbTitleService;
import com.dawn.service.TitleDescService;
import com.dawn.util.Result;
import com.dawn.util.Result1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
public class TbCategoryController {
	@Resource
	private TbCategoryService tbCategoryService;
	@Resource
	private TbTitleService tbTitleService;
	@Resource
	private TitleDescService titleDescService;

	// 查询知识点
	@RequestMapping("/title/tree")
	@ResponseBody
	public Result queryCategory(@RequestParam(value = "categoryid") long categoryid, @RequestParam(value = "page") int page, @RequestParam(value = "rows",defaultValue = "10") int rows) {

		return tbCategoryService.queryCategory1(categoryid,page,rows);
	}

	// 新增知识点
	@RequestMapping("/saveTree")
	@ResponseBody
	public Result1 saveCategory(@RequestParam(value = "parentId", defaultValue = "0") long parentId, String classname, TbCategory tbCategory) {
		tbCategory.setParentid(parentId);
		tbCategory.setClassname(classname);
		try {
			tbCategoryService.saveCategory(tbCategory);
			Result1 r = new Result1();
			r.setSuccess(true);
			return r;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Result1 r = new Result1();
			r.setSuccess(false);
			return r;

		}
	}

	// 修改知识点
	@RequestMapping("/updateTree")
	@ResponseBody
	public Result1 updateCategory(@RequestParam(value = "categordId", defaultValue = "0") long categordId, String classname, HttpServletRequest request) {
		TbCategory tbCategory = tbCategoryService.queryById(categordId);
		tbCategory.setCategordId(categordId);
		tbCategory.setClassname(classname);
		try {
			tbCategoryService.updateCategory(tbCategory);
			Result1 r = new Result1();
			r.setSuccess(true);
			return r;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Result1 r = new Result1();
			r.setSuccess(false);
			return r;

		}
	}

	//修改知识点的单查回显操作
	@RequestMapping("/findOne")
	@ResponseBody
	public TbCategory findOne(long id) {
		return tbCategoryService.findTbCategory(id);
	}

	// 删除知识点
	@RequestMapping("/itemCat/delete")
	@ResponseBody
	public Result1 deleteCategorty(long[] ids) {
		for (long id : ids) {
			List<TbCategory> list = tbCategoryService.getChildList(id);
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Long id1 = list.get(i).getCategordId();
					List<TbTitle> titlelist = tbTitleService.getTitleList(id1);
					if (titlelist.size() > 0) {
						for (int j = 0; j < titlelist.size(); j++) {
							Long titleid = titlelist.get(j).getTbtitleId();
							tbTitleService.delTitle(titleid);

							titleDescService.deleteByTitleId(titleid);
						}
					}
					tbCategoryService.deleteCategory(id1);
				}
				tbCategoryService.deleteCategory(id);
			} else {
				List<TbTitle> titlelist1 = tbTitleService.getTitleList(id);
				if (titlelist1.size() > 0) {
					for (int j = 0; j < titlelist1.size(); j++) {
						Long titleid1 = titlelist1.get(j).getTbtitleId();
						tbTitleService.delTitle(titleid1);
						titleDescService.deleteByTitleId(titleid1);
					}
				}
				tbCategoryService.deleteCategory(id);
			}
		}
		Result1 result = new Result1();
		result.setSuccess(true);
		return result;
	}
}