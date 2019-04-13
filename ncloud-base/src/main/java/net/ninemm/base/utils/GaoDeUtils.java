package net.ninemm.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.LogKit;
import com.jfinal.kit.StrKit;

import javax.xml.bind.SchemaOutputResolver;

/**
 * 高德
 *
 * @author Eric.Huang
 * @date 2018-09-19 10:48
 **/

public class GaoDeUtils {

    private static final String GEO_CODER_URL = "http://restapi.amap.com/v3/geocode/regeo?location=${location}&output=${output}&key=${key}";
    public static void main(String[] args) {//116.393058,39.959857
        //String city = getCity("792626a8e422ea6fc7bc2ead87661b78", Double.parseDouble("114.34573"),Double.parseDouble("30.52892"));
        //114.34573,30.52892
        System.out.println(getAddresJson("792626a8e422ea6fc7bc2ead87661b78", Double.parseDouble("114.34573"),Double.parseDouble("30.52892")));
    }
    public static String getCity(String key, Double lng, Double lat) {

        JSONObject locationObj = getLocationInfo(key, lng, lat);
        if (locationObj == null) {
            return null;
        }

        JSONObject obj = locationObj.getJSONObject("regeocode")
                .getJSONObject("addressComponent");
        return obj.getString("city");
    }

    public static JSONObject getLocationInfo(String key, Double lng, Double lat) {
        String url = GEO_CODER_URL.replace("${location}", lng + "," + lat)
                .replace("${output}", "json").replace("${key}", key);
        try {
            String json = HttpUtils.get(url);
            JSONObject obj = JSONObject.parseObject(json);
            LogKit.info("\n"+"经纬度查询地址为：" + url);
            LogKit.info("\n"+"经纬度坐标返回结果为：" + obj.toString());
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @author Eric Huang
     * @date 2018-09-19 11:31
     * @param lng   经度
     * @param lat   纬度
     * @return java.lang.String
     **/
    public static String getAddress(String key, Double lng, Double lat) {  //lat经度，lng纬度

        JSONObject locationObj = getLocationInfo(key, lng, lat);
        if (locationObj == null) {
            return null;
        }

        JSONObject obj = locationObj.getJSONObject("regeocode");
        JSONObject addressComponent = obj.getJSONObject("addressComponent");
        String province = addressComponent.getString("province");
        String city = addressComponent.getString("city");
        StringBuilder address = new StringBuilder();
        //直辖市的省份名称和城市名称一样，判断重复时去掉
        if (province != null && city != null && province.equals(city)) {
            address.append(city)
                .append(addressComponent.getString("district"))
                .append(addressComponent.getString("street"));
            
            String township = addressComponent.getString("township");
            if (!StrKit.equals(township, "[]")) { 
            	address.append(township);
            }

            JSONObject streetNumber = addressComponent.getJSONObject("streetNumber");
            if (streetNumber != null) {
	            String street = streetNumber.getString("street");
	            if (StrKit.notBlank(street)) {
	                address.append(street);
	            }
	            
	            String number = streetNumber.getString("number");
	            if (StrKit.notBlank(number)) {
	                address.append(number);
	            }
            }
        } else {
            address.append(province).append(city).append(addressComponent.getString("district"));
            
            String township = addressComponent.getString("township");
            if (!StrKit.equals(township, "[]")) { 
            	address.append(township);
            }

            JSONObject streetNumber = addressComponent.getJSONObject("streetNumber");
            if (streetNumber != null) {
	            String street = streetNumber.getString("street");
	            if (StrKit.notBlank(street)) {
	                address.append(street);
	            }
	
	            String number = streetNumber.getString("number");
	            if (StrKit.notBlank(number)) {
	                address.append(number);
	            }
            }
        }

        return address.toString();
    }

    public static JSONObject getAddresJson(String key, Double lng, Double lat) {  //lat经度，lng纬度
        JSONObject addressJson = new JSONObject();
        JSONObject locationObj = getLocationInfo(key, lng, lat);
        if (locationObj == null) {
            return null;
        }

        JSONObject obj = locationObj.getJSONObject("regeocode");
        JSONObject addressComponent = obj.getJSONObject("addressComponent");
        String province = addressComponent.getString("province");
        String city = addressComponent.getString("city");
        String district = addressComponent.getString("district");
        addressJson.put("province",province);
        addressJson.put("city",city);
        addressJson.put("district",district);

        StringBuilder address = new StringBuilder();
        //直辖市的省份名称和城市名称一样，判断重复时去掉
        if (province != null && city != null && province.equals(city)) {
            address.append(city)
                    .append(addressComponent.getString("district"))
                    .append(addressComponent.getString("street"));

            String township = addressComponent.getString("township");
            if (!StrKit.equals(township, "[]")) {
                address.append(township);
            }

            JSONObject streetNumber = addressComponent.getJSONObject("streetNumber");
            if (streetNumber != null) {
                String street = streetNumber.getString("street");
                if (StrKit.notBlank(street)) {
                    address.append(street);
                }

                String number = streetNumber.getString("number");
                if (StrKit.notBlank(number)) {
                    address.append(number);
                }
            }
        } else {
            address.append(province).append(city).append(addressComponent.getString("district"));

            String township = addressComponent.getString("township");
            if (!StrKit.equals(township, "[]")) {
                address.append(township);
            }

            JSONObject streetNumber = addressComponent.getJSONObject("streetNumber");
            if (streetNumber != null) {
                String street = streetNumber.getString("street");
                if (StrKit.notBlank(street)) {
                    address.append(street);
                }

                String number = streetNumber.getString("number");
                if (StrKit.notBlank(number)) {
                    address.append(number);
                }
            }
        }
        addressJson.put("address",address);
        return addressJson;
    }

}
