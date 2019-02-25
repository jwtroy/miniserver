package com.tensquare.recruit.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/11
 * @Description:
 */
@Entity
@Table(name = "tb_recruit")
public class Recruit implements Serializable{
    private String id;
    private String jobname;
    private String salary;
    private String condition;
    private String education;
    private String type;
    private String address;
    private String eid;
    private Timestamp createtime;
    private String state;
    private String url;
    private String label;
    private String content1;
    private String content2;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jobname")
    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    @Basic
    @Column(name = "salary")
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "condition")
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "eid")
    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "content1")
    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    @Basic
    @Column(name = "content2")
    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruit tbRecruit = (Recruit) o;
        return Objects.equals(id, tbRecruit.id) &&
                Objects.equals(jobname, tbRecruit.jobname) &&
                Objects.equals(salary, tbRecruit.salary) &&
                Objects.equals(condition, tbRecruit.condition) &&
                Objects.equals(education, tbRecruit.education) &&
                Objects.equals(type, tbRecruit.type) &&
                Objects.equals(address, tbRecruit.address) &&
                Objects.equals(eid, tbRecruit.eid) &&
                Objects.equals(createtime, tbRecruit.createtime) &&
                Objects.equals(state, tbRecruit.state) &&
                Objects.equals(url, tbRecruit.url) &&
                Objects.equals(label, tbRecruit.label) &&
                Objects.equals(content1, tbRecruit.content1) &&
                Objects.equals(content2, tbRecruit.content2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, jobname, salary, condition, education, type, address, eid, createtime, state, url, label, content1, content2);
    }
}
