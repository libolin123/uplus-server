package com.tianyaleixiaolin.uplusserver.global.zip;

import java.io.InputStream;

/**
 * @author Mr.li wrote on 2019/2/11.
 */
public class ZipStreamEntity {
    public String name;
    public InputStream inputstream;

    public ZipStreamEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ZipStreamEntity(String name, InputStream inputstream) {
        super();
        this.name = name;
        this.inputstream = inputstream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getInputstream() {
        return inputstream;
    }

    public void setInputstream(InputStream inputstream) {
        this.inputstream = inputstream;
    }

}
