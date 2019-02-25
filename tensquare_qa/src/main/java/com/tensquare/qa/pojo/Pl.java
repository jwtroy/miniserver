package com.tensquare.qa.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/13
 * @Description:
 */
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable{
    private String problemid;
    private String labelid;

    @Id
    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    @Id
    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pl pl = (Pl) o;
        return Objects.equals(problemid, pl.problemid) &&
                Objects.equals(labelid, pl.labelid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemid, labelid);
    }
}
