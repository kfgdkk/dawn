package com.dawn.service;

import com.dawn.dto.TitleDescDto;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;

public interface TitleService {

	Result getTitleAuditList(int pageNum, int pageSize, long userId);

    DawnResult delTitle(long tbtitleId);

    DawnResult delDesc(long tbtitleId);

    TitleDescDto selectTitleById(Long tbtitleId);

    DawnResult updateTitle(long tbtitleId, String title, String titleDesc);

}
