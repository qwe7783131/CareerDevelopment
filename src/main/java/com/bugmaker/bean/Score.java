package com.bugmaker.bean;
/**
 *      分数表
 *
 */
public class Score {
    private String id;

    private String stuId;

    private String teacId;

    private Double teacScore;

    private Double outteacScore;

    private Integer no;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getTeacId() {
        return teacId;
    }

    public void setTeacId(String teacId) {
        this.teacId = teacId == null ? null : teacId.trim();
    }

    public Double getTeacScore() {
        return teacScore;
    }

    public void setTeacScore(Double teacScore) {
        this.teacScore = teacScore;
    }

    public Double getOutteacScore() {
        return outteacScore;
    }

    public void setOutteacScore(Double outteacScore) {
        this.outteacScore = outteacScore;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}