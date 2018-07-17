package com.huangpeng.cloud.model;

import java.util.Date;

public class HaPersonAudioRecordEntity {
    private String id;

    private Date time;

    private String subject;

    private String type;

    private Date duration;

    private String createOrganCode;

    private String createOrganName;

    private String createPersonIdNo;

    private String createPersonName;

    private Date createDate;

    private String deleteOrganCode;

    private String deleteOrganName;

    private String deletePersonIdNo;

    private String deletePersonName;

    private Date deleteDate;

    private String updateOrganCode;

    private String updateOrganName;

    private String updatePersonIdNo;

    private String updatePersonName;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode == null ? null : createOrganCode.trim();
    }

    public String getCreateOrganName() {
        return createOrganName;
    }

    public void setCreateOrganName(String createOrganName) {
        this.createOrganName = createOrganName == null ? null : createOrganName.trim();
    }

    public String getCreatePersonIdNo() {
        return createPersonIdNo;
    }

    public void setCreatePersonIdNo(String createPersonIdNo) {
        this.createPersonIdNo = createPersonIdNo == null ? null : createPersonIdNo.trim();
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName == null ? null : createPersonName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDeleteOrganCode() {
        return deleteOrganCode;
    }

    public void setDeleteOrganCode(String deleteOrganCode) {
        this.deleteOrganCode = deleteOrganCode == null ? null : deleteOrganCode.trim();
    }

    public String getDeleteOrganName() {
        return deleteOrganName;
    }

    public void setDeleteOrganName(String deleteOrganName) {
        this.deleteOrganName = deleteOrganName == null ? null : deleteOrganName.trim();
    }

    public String getDeletePersonIdNo() {
        return deletePersonIdNo;
    }

    public void setDeletePersonIdNo(String deletePersonIdNo) {
        this.deletePersonIdNo = deletePersonIdNo == null ? null : deletePersonIdNo.trim();
    }

    public String getDeletePersonName() {
        return deletePersonName;
    }

    public void setDeletePersonName(String deletePersonName) {
        this.deletePersonName = deletePersonName == null ? null : deletePersonName.trim();
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getUpdateOrganCode() {
        return updateOrganCode;
    }

    public void setUpdateOrganCode(String updateOrganCode) {
        this.updateOrganCode = updateOrganCode == null ? null : updateOrganCode.trim();
    }

    public String getUpdateOrganName() {
        return updateOrganName;
    }

    public void setUpdateOrganName(String updateOrganName) {
        this.updateOrganName = updateOrganName == null ? null : updateOrganName.trim();
    }

    public String getUpdatePersonIdNo() {
        return updatePersonIdNo;
    }

    public void setUpdatePersonIdNo(String updatePersonIdNo) {
        this.updatePersonIdNo = updatePersonIdNo == null ? null : updatePersonIdNo.trim();
    }

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName == null ? null : updatePersonName.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}