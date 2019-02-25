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
@Table(name = "tb_ul")
public class Ul implements Serializable{
    private String uid;
    private String lid;

    @Id
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Id
    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ul ul = (Ul) o;
        return Objects.equals(uid, ul.uid) &&
                Objects.equals(lid, ul.lid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, lid);
    }
}
