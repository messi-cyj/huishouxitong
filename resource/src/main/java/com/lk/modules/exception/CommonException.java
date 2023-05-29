package com.lk.modules.exception;


/**
 * @author Qian
 */
public class CommonException extends RuntimeException implements CommonError {

    private CommonError commonError;

    private Integer errCode = -1;
    private String errMsg;

    public CommonException(Integer errCode, String errMsg) {
        super();
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonException(String errMsg) {
        super();
        this.errCode = -1;
        this.errMsg = errMsg;
    }

    public CommonException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public CommonException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }


    @Override
    public int getErrCode() {
        if (this.errCode == null) {
            this.errCode = this.commonError.getErrCode();
        }
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        if (this.errMsg == null) {
            this.errMsg = this.commonError.getErrMsg();
        }
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    @Override
    public String getMessage() {
        if (this.errMsg == null) {
            this.errMsg = this.commonError.getErrMsg();
        }
        return this.errMsg;
    }
}
