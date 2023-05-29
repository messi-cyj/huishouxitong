package com.lk.modules.exception;

import com.lk.modules.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Qian
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R doError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception ex) {
        Map<String, Object> responseData = new HashMap<>(16);
        if (ex instanceof CommonException) {
            CommonException commonException = (CommonException) ex;
            responseData.put("errCode", commonException.getErrCode());
            responseData.put("errMsg", commonException.getErrMsg());
            log.error(commonException.getErrMsg(), commonException);
        } else {
            responseData.put("errCode", EmError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", EmError.UNKNOWN_ERROR.getErrMsg());
            log.error(EmError.UNKNOWN_ERROR.getErrMsg(), ex);
        }
        return R.error(responseData);
    }
}
