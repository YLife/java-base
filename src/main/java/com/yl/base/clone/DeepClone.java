package com.yl.base.clone;

import java.io.*;

/**
 * @description 深克隆
 *  1、普通实现；
 *  2、序列化方式实现；
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/22 16:17
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/22      yanglun            v1.0.0              修改原因
 */
public class DeepClone implements Cloneable, Serializable {

    private int id;
    private CloneTemp cloneTemp;

    public DeepClone(int id, CloneTemp cloneTemp) {
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

    // 深克隆
    public Object deepCloneBySerialize() throws IOException, ClassNotFoundException {
        // 将对象写入流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        // 将对象从流中读出
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepClone deepClone = (DeepClone) super.clone();
        deepClone.cloneTemp = (CloneTemp) deepClone.cloneTemp.clone();
        return deepClone;
    }

    @Override
    public String toString() {
        return "{\"ID\":" + id + ", \"CLONE_TEMP:\"{\"ID:\"" + cloneTemp.getId()
                + ", \"NAME:\"" + cloneTemp.getName() + "\"}\"}" ;
    }
}
