package frameConstatnt;


import enums.ConfigProperties;
import utiles.MobilePropertyUtils;

public class MobileFrameConstant {
    private MobileFrameConstant() {

    }

    private static final String RESOURCESPATH = System.getProperty("user.dir");
    private static final String ANDROID_APPLICATION_PATH = RESOURCESPATH + "/src/main/resources/app-visionstg-debug.apk";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/src/main/resources/config/config.properties";
    private static final String EXCELFILEPATH = RESOURCESPATH + "/src/main/resources/excelFiles/MobileTestData.xlsx";
    private static final String JSONFILEPATH = RESOURCESPATH + "/src/main/resources/jsonFile/desireCapability.json";
    private static final String EXTENTREPORTFOLDERPATH = RESOURCESPATH + "/extent-test-output";
    private static String extentReportFilePath = "";
    private static final String RUNMANAGERSHEET = "Sheet1";
    private static final String ITERATIONDATASHEET = "Data";

    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();

        }
        return extentReportFilePath;
    }

    private static String createReportPath() throws Exception {
        if (MobilePropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "/index.html";
        }
    }

    public static String getAndroidApplication() {
        return ANDROID_APPLICATION_PATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String excelFilePath() {
        return EXCELFILEPATH;
    }

    public static String jsonFilePath() {
        return JSONFILEPATH;
    }

    public static String runManagerSheet() {
        return RUNMANAGERSHEET;
    }

    public static String iterationSheet() {
        return ITERATIONDATASHEET;
    }


}
