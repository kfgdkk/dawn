package com.dawn.service.impl;

import com.dawn.dto.TitleDescDto;
import com.dawn.mapper.TbDescMapper;
import com.dawn.mapper.TbTitleMapper;
import com.dawn.pojo.TbDesc;
import com.dawn.pojo.TbDescExample;
import com.dawn.pojo.TbTitle;
import com.dawn.pojo.TbTitleExample;
import com.dawn.service.TitleService;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2018/1/28.
 */
@Service
public class TitleServiceImpl implements TitleService{
    @Autowired
    private TbTitleMapper titleMapper;
    @Autowired
    private TbDescMapper descMapper;
    public Result getTitleAuditList(int pageNum, int pageSize,long userId) {
        PageHelper.startPage(pageNum,pageSize);
        TbTitleExample example = new TbTitleExample();
        TbTitleExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo((int) userId);
        criteria.andAuditStatusNotEqualTo("2");
        Page<TbTitle> pageInfo = (Page<TbTitle>)titleMapper.selectByExample(example);
        Result result = new Result();
        result.setTotal(pageInfo.getTotal());
        result.setRows(pageInfo.getResult());
        return result;
    }

    // 删除题目
    public DawnResult delTitle(long tbtitleId) {
        titleMapper.deleteByPrimaryKey(tbtitleId);
        return DawnResult.ok();
    }

    // 删除答案

    public DawnResult delDesc(long titleId) {
        TbDescExample example = new TbDescExample();
        TbDescExample.Criteria criteria = example.createCriteria();
        criteria.andTitleIdEqualTo(titleId);
        descMapper.deleteByExample(example);
        return DawnResult.ok();
    }
    //单查
    public TitleDescDto selectTitleById(Long tbtitleId) {
        TitleDescDto titleDescDto = new TitleDescDto();
        TbTitle tbTitle =titleMapper.selectByPrimaryKey(tbtitleId);
        titleDescDto.setTitle(tbTitle.getTitle());
        titleDescDto.setTbtitleId(tbtitleId);
        TbDescExample example = new TbDescExample();
        TbDescExample.Criteria criteria = example.createCriteria();
        criteria.andTitleIdEqualTo(tbtitleId);
        List<TbDesc> descs = descMapper.selectByExampleWithBLOBs(example);
        if (descs.size()>0){
            titleDescDto.setTitleDesc(descs.get(0).getTitleDesc());
        }
        return titleDescDto;
    }

    public DawnResult updateTitle(long tbtitleId, String title, String titleDesc) {
        TbTitle tbTitle = new TbTitle();
        tbTitle.setTitle(title);
        tbTitle.setTbtitleId(tbtitleId);
        tbTitle.setUpdated(new Date());
        titleMapper.updateByPrimaryKeySelective(tbTitle);
        TbDescExample example = new TbDescExample();
        TbDescExample.Criteria criteria = example.createCriteria();
        criteria.andTitleIdEqualTo(tbtitleId);
        List<TbDesc> descs = descMapper.selectByExample(example);
        TbDesc desc = new TbDesc();
        desc.setTitleDesc(titleDesc);
        desc.setTitleId(tbtitleId);
        desc.setUpdated(new Date());
        if (descs.size()>0){
            descMapper.updateByExampleSelective(desc,example);
        }else {
            desc.setCreated(new Date());
            descMapper.insert(desc);
        }
        return DawnResult.ok();
    }


}
