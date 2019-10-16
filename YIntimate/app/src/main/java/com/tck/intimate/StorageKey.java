package com.tck.intimate;

import androidx.annotation.StringDef;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>description:</p>
 * <p>created on: 2019/10/15 16:31</p>
 *
 * @author tck
 * @version 1.0
 */

@Documented
@Retention(RetentionPolicy.SOURCE)
@StringDef({

})
public @interface AppType {

    String YAOYANSHE_PACKAGE = "";
    String SHIYANTIAN_PACKAGE = "com.yaoyanshe.trialfield";
}
