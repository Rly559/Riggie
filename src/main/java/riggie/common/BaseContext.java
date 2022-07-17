package riggie.common;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 14:20
 *
 * 基于TreadLocal封装工具类，用于保存和获取当前登录用户的id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
