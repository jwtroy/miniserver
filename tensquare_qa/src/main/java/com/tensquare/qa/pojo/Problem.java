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
@Table(name = "tb_problem")
public class Problem implements Serializable{
    private String id;
    private String title;
    private String content;
    private Timestamp createtime;
    private Timestamp updatetime;
    private String userid;
    private String nickname;
    private Long visits;
    private Long thumbup;
    private Long reply;
    private String solve;
    private String replyname;
    private Timestamp replytime;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public Long getThumbup() {
        return thumbup;
    }

    public void setThumbup(Long thumbup) {
        this.thumbup = thumbup;
    }

    public Long getReply() {
        return reply;
    }

    public void setReply(Long reply) {
        this.reply = reply;
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname;
    }

    public Timestamp getReplytime() {
        return replytime;
    }

    public void setReplytime(Timestamp replytime) {
        this.replytime = replytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Objects.equals(id, problem.id) &&
                Objects.equals(title, problem.title) &&
                Objects.equals(content, problem.content) &&
                Objects.equals(createtime, problem.createtime) &&
                Objects.equals(updatetime, problem.updatetime) &&
                Objects.equals(userid, problem.userid) &&
                Objects.equals(nickname, problem.nickname) &&
                Objects.equals(visits, problem.visits) &&
                Objects.equals(thumbup, problem.thumbup) &&
                Objects.equals(reply, problem.reply) &&
                Objects.equals(solve, problem.solve) &&
                Objects.equals(replyname, problem.replyname) &&
                Objects.equals(replytime, problem.replytime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, content, createtime, updatetime, userid, nickname, visits, thumbup, reply, solve, replyname, replytime);
    }
}
