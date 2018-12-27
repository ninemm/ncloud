/*
 * Copyright (c) 2015-2018, Eric Huang 黄鑫 (ninemm@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ninemm.base.utils;

import com.jfinal.kit.StrKit;
import org.joda.time.DateTime;

/**
 * 日期工具类
 *
 * @author Eric.Huang
 * @date 2018-07-11 16:27
 **/

public class DateUtils {

    public static final String DEFAULT_DATE_FORMA = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 功能描述：当天的起始时间
     * 输入参数：
     * @return
     * 返回类型：Date
     * 创建人：eric
     * 日期：2016年4月13日
     */
    public static String getStartOfDay(String date) {
        DateTime dateTime = DateTime.now();

        if (StrKit.notBlank(date)) {
            dateTime = DateTime.parse(date);
        }

        dateTime = dateTime.withTimeAtStartOfDay();
        return dateTime.toString(DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 功能描述：当天的结束时间
     * 输入参数：
     * @return
     * 返回类型：Date
     * 创建人：eric
     * 日期：2016年4月13日
     */
    public static String getEndOfDay(String date) {
        DateTime dateTime = DateTime.now();

        if (StrKit.notBlank(date)) {
            dateTime = DateTime.parse(date);
        }

        dateTime = dateTime.millisOfDay().withMaximumValue();
        return dateTime.toString(DEFAULT_DATETIME_FORMAT);
    }
}
