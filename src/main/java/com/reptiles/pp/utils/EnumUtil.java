package com.reptiles.pp.utils;


import com.reptiles.pp.enums.CodeEnum;

public class EnumUtil {

    /**
     * 得到相应的枚举状态码
     * <T extends CodeEnum> 静态方法对泛型进行说明
     *
     * @param message
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByMessage(String message, Class<T> enumClass) {

        //getEnumConstants() 反射取出Enum所有常量的属性值
        for (T each : enumClass.getEnumConstants()) {
            if (message.equals(each.getMessage())) {
                return each;
            }
        }

        return null;
    }
}
