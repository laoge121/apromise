package com.laoge.apromise.api.entity;

import java.io.Serializable;

/**
 * Created by yuhou on 2017/5/8.
 */
public class AddressEntity implements Serializable {

    private Long id;

    private String province;

    private String city;

    public AddressEntity() {
    }

    public AddressEntity(Long id, String province, String city) {
        this.id = id;
        this.province = province;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressEntry{");
        sb.append("id=").append(id);
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
