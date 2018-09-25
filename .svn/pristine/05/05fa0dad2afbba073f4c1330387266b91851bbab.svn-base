package com.byc.merchants.merchants_cms.enums;



import com.byc.merchants.merchants_cms.util.CommonUtils;
import com.byc.merchants.merchants_cms.util.TimeUtils;

import java.util.Calendar;
import java.util.Date;

public enum OssKeyEnum {

    MER_IMSGE("mer_image", "商户图片"),
    MER_STORES_IMSGE("mer_stores_image", "商户门店图片");
    public String CODE = "";
    public String REMARK = "";

    OssKeyEnum(String code, String remark) {
        CODE = code;
        REMARK = remark;
    }

    public static OssKeyEnum getKey(String picType) {
        OssKeyEnum[] enums = OssKeyEnum.values();
        for (OssKeyEnum ossKeyEnum : enums) {
            if (picType.equals(ossKeyEnum.CODE)) {
                return ossKeyEnum;
            }
        }
        return null;
    }

    public static String getKey(OssKeyEnum enums) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int days = cal.get(Calendar.DAY_OF_MONTH);
        return enums.CODE + "/" + year + "/" + month + "/" + days + "/" + TimeUtils.getSysTime("HHmmss") + CommonUtils.getRandom(999999999) + ".data";
    }

}
