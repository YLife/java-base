package com.yl.base.clone;

import java.io.Serializable;

/**
 * @description 克隆引用变量模板
 *
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/22 16:07
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/22      yanglun            v1.0.0              修改原因
 */
public class CloneTemp implements Cloneable, Serializable {

    private int id;
    private String name;

    public CloneTemp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
