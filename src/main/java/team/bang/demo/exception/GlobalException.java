package team.bang.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team.bang.demo.model.bean.CommonResult;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> toHandlerException(Exception e) {
        e.printStackTrace();
        return new CommonResult<>(40001, "Error", "?");
    }
}
