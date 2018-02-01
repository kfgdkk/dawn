package com.dawn.mapper;

import com.dawn.dto.MobileDto;

import java.util.List;

/**
 * Created by Administrator on 2018/1/29 0029.
 */
public interface MobileDtoMapper {
    List<MobileDto> selectMobileDto(Integer pid);
}
