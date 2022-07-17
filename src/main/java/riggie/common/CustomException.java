package riggie.common;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 16:13
 *
 * 自定义业务异常
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
