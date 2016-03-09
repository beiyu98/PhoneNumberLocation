package com.project.android.bruce.phonenumberlocation;

/**
 * Created by shuai on 2016/3/9.
 * JSON返回示例 :
 {
 "errNum": 0,
 "retMsg": "success",
 "retData": {
 "phone": "15210011578",
 "prefix": "1521001",
 "supplier": "移动 ",
 "province": "北京 ",
 "city": "北京 ",
 "suit": "152卡"
 }
 }
 备注 :
 "phone": 手机号码,
 "prefix": 手机号码前7位,
 "supplier": "移动 ",
 "province": 省份,
 "city": 城市,
 "suit": "152卡"
 */
public class NumberData {

    private String phoneNumber;
    private String prefix;
    private String numberSupplier;
    private String numberProvince;
    private String numberCity;
    private String numberSuit;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumberSupplier() {
        return numberSupplier;
    }

    public void setNumberSupplier(String numberSupplier) {
        this.numberSupplier = numberSupplier;
    }

    public String getNumberProvince() {
        return numberProvince;
    }

    public void setNumberProvince(String numberProvince) {
        this.numberProvince = numberProvince;
    }

    public String getNumberCity() {
        return numberCity;
    }

    public void setNumberCity(String numberCity) {
        this.numberCity = numberCity;
    }

    public String getNumberSuit() {
        return numberSuit;
    }

    public void setNumberSuit(String numberSuit) {
        this.numberSuit = numberSuit;
    }
}
