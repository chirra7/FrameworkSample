package in.ibm.utilities;

import in.ibm.constants.Constants;
import in.ibm.enums.DeviceCapabilities;
import in.ibm.enums.DeviceOSType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class DevicesDataLoadAndRetrieveJSONWork {

    JSONParser parser = null;

    public Object loadJSONFile(String folderPath, String fileName) {

        String filePath = folderPath + "\\" + fileName;
        parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            return obj;
        } catch (Exception e) {
            System.err.println("No file found with path " + filePath + "\n" + e.toString());
        }
        return null;
    }

    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> devicesInfo = null;

    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> loadAllMobileDevicesInfo() {

        devicesInfo =
                new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>>();

        JSONObject obj = (JSONObject) loadJSONFile(Constants.mobilesDevicesListJSONFolderPath, Constants.mobilesDevicesListJSONFilePath);

        System.out.println(obj.toJSONString());

        String url = (String) obj.get("URL");
        String userId = (String) obj.get("USERID");
        String password = (String) obj.get("PASSWOED");

        System.out.println("url : " + url);
        System.out.println("userId : " + userId);
        System.out.println("password : " + password);

        JSONObject osTypes = (JSONObject) obj.get("MobilesDevicesInfo");
        JSONArray androidOSDevicesList = (JSONArray) osTypes.get("Android");
        JSONArray iosOSDevicesList = (JSONArray) osTypes.get("IOS");

        System.out.println("androidOSDevicesList : " + androidOSDevicesList);
        System.out.println("iosOSDevicesList : " + iosOSDevicesList);

        String deviceName = "";
        String version = "";
        String bundileId = "";
        LinkedHashMap<String, String> capabilities_LHM = null;
        LinkedHashMap<String, LinkedHashMap<String, String>> mobileDeviceCapabilities_LLHM = new LinkedHashMap<String, LinkedHashMap<String, String>>();

        for (Object mobObj : androidOSDevicesList) {
            capabilities_LHM = new LinkedHashMap<String, String>();
            JSONObject capabilityPbj = (JSONObject) mobObj;
            deviceName = capabilityPbj.get("DeviceName").toString();
            version = capabilityPbj.get("Version").toString();
            bundileId = capabilityPbj.get("BundileId").toString();

            capabilities_LHM.put("" + DeviceCapabilities.DEVICENAME, deviceName);
            capabilities_LHM.put("" + DeviceCapabilities.OSNAME, "" + DeviceCapabilities.ANDROID);
            capabilities_LHM.put("" + DeviceCapabilities.OSVERSION, version);
            capabilities_LHM.put("" + DeviceCapabilities.BUINDLEID, bundileId);

            mobileDeviceCapabilities_LLHM.put(deviceName, capabilities_LHM);
        }
        devicesInfo.put("" + DeviceCapabilities.ANDROID, mobileDeviceCapabilities_LLHM);

        mobileDeviceCapabilities_LLHM = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        for (Object mobObj : iosOSDevicesList) {
            capabilities_LHM = new LinkedHashMap<String, String>();
            JSONObject capabilityPbj = (JSONObject) mobObj;
            deviceName = capabilityPbj.get("DeviceName").toString();
            version = capabilityPbj.get("Version").toString();
            bundileId = capabilityPbj.get("BundileId").toString();

            capabilities_LHM.put("" + DeviceCapabilities.DEVICENAME, deviceName);
            capabilities_LHM.put("" + DeviceCapabilities.OSNAME, "" + DeviceCapabilities.IOS);
            capabilities_LHM.put("" + DeviceCapabilities.OSVERSION, version);
            capabilities_LHM.put("" + DeviceCapabilities.BUINDLEID, bundileId);

            mobileDeviceCapabilities_LLHM.put(deviceName, capabilities_LHM);
        }
        devicesInfo.put("" + DeviceCapabilities.IOS, mobileDeviceCapabilities_LLHM);

        System.out.println("devicesInfo : " + devicesInfo);

        return devicesInfo;

    }

    public void getMobileDeviceInfo(DeviceOSType osName, String deviceName) {

        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> deviceCapabilitiesInfo = loadAllMobileDevicesInfo();
        LinkedHashMap<String, String> deviceCapabilities = deviceCapabilitiesInfo.get(osName.toString()).get(deviceName);
        System.out.println("deviceCapabilities : " + deviceCapabilities);
    }

    public static void main(String[] args) {

        DevicesDataLoadAndRetrieveJSONWork clsObj = new DevicesDataLoadAndRetrieveJSONWork();
        clsObj.getMobileDeviceInfo(DeviceOSType.ANDROID, "Samusng_Gelaxy");
    }


}
