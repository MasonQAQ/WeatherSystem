package edu.hehai.shuili.weather.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import edu.hehai.shuili.weather.pojo.group.UserAdd;
import edu.hehai.shuili.weather.pojo.group.UserPassword;
import edu.hehai.shuili.weather.pojo.group.UserUpdate;

import javax.validation.constraints.*;


/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 2:23 PM
 * @package_name: edu.hehai.shuili.weather.pojo
 * @Description: 用户表
 */

//********************************************************************************
//                              Here is a doc
//********************************************************************************
/**
 * Bean Validation 中内置的 constraint
 * @Null   被注释的元素必须为 null
 * @NotNull    被注释的元素必须不为 null
 * @AssertTrue     被注释的元素必须为 true
 * @AssertFalse    被注释的元素必须为 false
 * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past   被注释的元素必须是一个过去的日期
 * @Future     被注释的元素必须是一个将来的日期
 * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 * Hibernate Validator 附加的 constraint
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0
 * @Email  被注释的元素必须是电子邮箱地址
 * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 * @NotEmpty   被注释的字符串的必须非空
 * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 */
//********************************************************************************


public class User implements Cloneable{

    //用户id
    @NotNull(message = "用户id不能为空", groups = { UserUpdate.class, UserPassword.class})
    private int userId;

    //用户名
    @NotNull(groups = { UserAdd.class})
    @Size(min = 6, max = 20, message = "用户名必须在6-20位", groups = { UserAdd.class})
    private String username;

    //昵称
    @NotNull(groups = { UserAdd.class, UserUpdate.class})
    @Size(min = 6, max = 20, message = "昵称必须在6-20位", groups = { UserAdd.class, UserUpdate.class })
    private String nickname;

    //密码(此处禁止进行序列化，返回给前端的数据中不能带密码)
    @JSONField(serialize = false)
    @NotNull(groups = { UserAdd.class, UserPassword.class})
    @Pattern(regexp="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"
            ,message="密码由6-20字母和数字组成，不能是纯数字或纯英文"
            ,groups = { UserAdd.class, UserPassword.class})
    private String password;

    //电话号码
    @NotNull(groups = { UserAdd.class, UserUpdate.class})
    @Pattern(regexp="^1[34578]\\d{9}$", message="手机号格式不正确",groups = { UserAdd.class, UserUpdate.class })
    private String phone;

    //用户邮箱
    @NotNull(groups = {UserAdd.class, UserUpdate.class})
    @Pattern(regexp = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}", message = "邮箱格式不正确", groups = {UserAdd.class, UserUpdate.class})
    private String email;

    //用户权限等级[0,1]
    @Min(value = 0, message = "权限不正确", groups = {UserAdd.class, UserUpdate.class})
    @Max(value = 1, message = "权限不正确", groups = {UserAdd.class, UserUpdate.class})
    private int privilege;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }


    @Override
    public Object clone() {
        User user = null;
        try {
            user = (User) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":")
                .append(userId);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"privilege\":")
                .append(privilege);
        sb.append('}');
        return sb.toString();
    }
}
