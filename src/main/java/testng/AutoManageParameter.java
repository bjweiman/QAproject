package testng;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 *
 * {@link TestResultListener#needAutoParameter(Method)} 中会根据设置,自动管理/填充用例参数
 *
 * <p>有这个注解,并且 {@link #autoManage()} 为 {@code true} 才会使用 {@link TestResultListener} 管理参数</p>
 *
 * <p>可以加到方法/类上</p>
 *
 * <p>2018/1/3 17:30</p>
 *
 * @author bjwieman
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoManageParameter {
}
