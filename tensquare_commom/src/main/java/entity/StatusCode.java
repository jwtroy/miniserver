package entity;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/4
 * @Description:
 */
public class StatusCode {
    public static final int OK = 20000;//成功
    public static final int ERROR = 20001;//失败
    public static final int LOGINERROR = 20002;//用户名或密码错误
    public static final int ACCESSERROR = 20003;//权限不足
    public static final int REMOTERROR = 20004;//远程调用失败
    public static final int REPERROR = 20005;//重复操作
}