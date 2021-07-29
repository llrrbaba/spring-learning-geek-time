package cn.rocker.ioc.overview.dependency.domain;

import cn.rocker.ioc.overview.dependency.annotation.Super;
import lombok.Data;
import lombok.ToString;

@Data
@Super
@ToString(callSuper = true)
public class SuperUser extends User {

    private String address;

}
