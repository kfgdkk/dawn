package com.dawn.dto;

/**
 * Created by Administrator on 2018/1/29 0029.
 */
public class MobileDto {
   /* t.tbtitle_id,
    t.title,
    t.created,
    m.create_time*/

    private Long tbtitleId;

    private String title;
    private  String  created;
    private String  createTime;

    public Long getTbtitleId() {
        return tbtitleId;
    }

    public void setTbtitleId(Long tbtitleId) {
        this.tbtitleId = tbtitleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
