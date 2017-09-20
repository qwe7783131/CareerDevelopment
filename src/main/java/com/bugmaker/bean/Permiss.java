package com.bugmaker.bean;
/**
 *      权限表
 */
public class Permiss {
    private String id;

    private String parentId;

    private String url;

    private String describe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    @Override
    public String toString() {
        return "Permiss{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", url='" + url + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}