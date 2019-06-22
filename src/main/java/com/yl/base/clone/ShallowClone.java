package com.yl.base.clone;

/**
 * @description 浅克隆
 *
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/22 15:42
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/22      yanglun            v1.0.0              修改原因
 */
public class ShallowClone implements Cloneable {

    private int id;
    private CloneTemp cloneTemp;

    public ShallowClone(int id, CloneTemp cloneTemp) {
        this.id = id;
        this.cloneTemp = cloneTemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CloneTemp getCloneTemp() {
        return cloneTemp;
    }

    public void setCloneTemp(CloneTemp cloneTemp) {
        this.cloneTemp = cloneTemp;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "{\"ID\":" + id + "\", \"CLONE_TEMP:\"{\"ID:\"" + cloneTemp.getId()
                + "\", \"NAME:\"" + cloneTemp.getName() + "\"}\"}" ;
    }
}
