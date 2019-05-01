package com.xlx.product.repository.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbTypeContextHolder {

    private final static ThreadLocal<DBType> holder = new ThreadLocal<DBType>();

    private final static ThreadLocal<Boolean> alwaysWrite = new ThreadLocal<Boolean>();

    public static DBType get() {
        if (alwaysWrite.get() != null && alwaysWrite.get()) {
            log.info("将强制使用Write");
            return DBType.MASTER;
        }
        log.info("获取到: "+holder.get().name());
        return holder.get();
    }

    public static void set(DBType dbType) {
        log.info("设置为: "+dbType.name());
        holder.set(dbType);
    }

    public static void clean() {
        log.info("清除...");
        holder.remove();
    }

    public static void setAlwaysWrite() {
        log.info("设置强制Write");
        alwaysWrite.set(true);
    }

    public static void cleanAlwaysWrite() {
        log.info("清除强制Write");
        clean();
        alwaysWrite.remove();
    }

}
