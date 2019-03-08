package com.tianyaleixiaolin.uplusserver.global.exception;


/**
 * @author Mr.li wrote on 2018/10/27.
 */
public class NoLoginException extends RuntimeException {

    public NoLoginException() {
        super();
    }

    public NoLoginException(String message) {
        super(message);
    }
}
