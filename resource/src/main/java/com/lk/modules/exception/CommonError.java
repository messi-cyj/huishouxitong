package com.lk.modules.exception;

/**
 * @author Qian
 */
public interface CommonError {

    int getErrCode();

    String getErrMsg();

    CommonError setErrMsg(String errMsg);

}
