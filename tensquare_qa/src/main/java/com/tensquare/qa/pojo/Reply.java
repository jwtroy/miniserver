package com.tensquare.qa.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/13
 * @Description:
 */
@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable{
    private String id;
    private String problemid;
    private String content;
    private Timestamp createtime;
    private Timestamp updatetime;
    private String userid;
    private String nickname;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return Objects.equals(id, reply.id) &&
                Objects.equals(problemid, reply.problemid) &&
                Objects.equals(content, reply.content) &&
                Objects.equals(createtime, reply.createtime) &&
                Objects.equals(updatetime, reply.updatetime) &&
                Objects.equals(userid, reply.userid) &&
                Objects.equals(nickname, reply.nickname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, problemid, content, createtime, updatetime, userid, nickname);
    }
}
