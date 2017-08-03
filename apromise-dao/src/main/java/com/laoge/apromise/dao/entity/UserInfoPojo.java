package com.laoge.apromise.dao.entity;

import java.io.Serializable;

/**
 * Created by yuhou on 2017/5/9.
 */
public class UserInfoPojo implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Long stime;

    public UserInfoPojo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStime() {
        return stime;
    }

    public void setStime(Long stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfoPojo{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", stime=").append(stime);
        sb.append('}');
        return sb.toString();
    }
}
