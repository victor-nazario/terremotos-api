package com.terremotospr.terremotospr;

import org.springframework.beans.BeanUtils;

/**
 * Created on March 5, 2020 - 3:18 PM
 *
 * @author Victor Nazario
 */
public final class Utils<I> {

    public static <I, O> O merge(I src, O dest) {
        return merge(src, dest);
    }

    public static <I, O> O merge(I src, O dest, String... ignoreProps) {
        BeanUtils.copyProperties(src, dest, ignoreProps);
        return dest;
    }
}
