package com.dawn.mapper;

import com.dawn.pojo.TbTitle;
import com.dawn.pojo.TbTitleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbTitleMapper {
	int countByExample(TbTitleExample example);

	int deleteByExample(TbTitleExample example);

	int deleteByPrimaryKey(Long tbtitleId);

	int insert(TbTitle record);

	int insertSelective(TbTitle record);

	List<TbTitle> selectByExampleWithBLOBs(TbTitleExample example);

	List<TbTitle> selectByExample(TbTitleExample example);

	List<TbTitle> getByTitleNameList(@Param("title") String titlename, @Param("userType") Integer userType);

	TbTitle selectByPrimaryKey(Long tbtitleId);

	int updateByExampleSelective(@Param("record") TbTitle record, @Param("example") TbTitleExample example);

	int updateByExampleWithBLOBs(@Param("record") TbTitle record, @Param("example") TbTitleExample example);

	int updateByExample(@Param("record") TbTitle record, @Param("example") TbTitleExample example);

	int updateByPrimaryKeySelective(TbTitle record);

	int updateByPrimaryKeyWithBLOBs(TbTitle record);

	int updateByPrimaryKey(TbTitle record);

	List<TbTitle> selectCollectionTitle(Integer pid);

	List<TbTitle> selectHRquestions();

	@Select(" SELECT title,tbtitle_id, clicknum FROM tb_title ORDER BY tb_title.clicknum DESC LIMIT 15")
	List<TbTitle> selecttopfifteen();
	@Select("SELECT t.audit_status,t.category_id,t.cause,t.clicknum,t.created,t.tbtitle_id,t.title,t.updated,t.userid,t.user_type FROM tb_title t WHERE audit_status=2 ORDER BY clicknum DESC limit 0,15")
	List<TbTitle> seeThrough();

	List<TbTitle> getTbTitleHF(@Param("nowdate") String nowdate,@Param("olddate7") String olddate7);
}