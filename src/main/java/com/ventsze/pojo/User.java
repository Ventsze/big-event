package com.ventsze.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

//lombok 在编译阶段，为实体类自动生成 setter getter toString
// 要使用lombok，需要在pom文件中引入依赖 ，在实体类上添加注解
@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore //让springmvc把当前对象转换成json字符串的时候，忽略password，最终json字符串就没有password属性了。
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}