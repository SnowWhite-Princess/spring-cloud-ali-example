package com.smart.sentinel.example.domian.dto.request;

import lombok.Data;

import java.util.List;

/**
 *
 * @author zhangwei
 */
@Data
public class OrderRequestParams extends BaseReqeustParams {
    private int uid;
    private List<Integer> ids;
    private String address;
    private String phone;
    /**
     * 1 表示顺丰
     * 2 圆通
     * 3 中通
     */
    private int expressType;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getExpressType() {
        return expressType;
    }

    public void setExpressType(int expressType) {
        this.expressType = expressType;
    }
}
