package dataProvider;


import frameConstatnt.MobileFrameConstant;
import org.testng.annotations.DataProvider;
import utiles.MobileExcelUtility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MobileDataProvider {

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider
    public static Object[] getData(Method m) {

        String testName = m.getName();

        if (list.isEmpty()) {
            list = MobileExcelUtility.getTestDetails(MobileFrameConstant.iterationSheet());
        }

        List<Map<String, String>> iterationList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("TestName").equalsIgnoreCase(testName) && (list.get(i).get("Execute").equalsIgnoreCase("yes"))) {
                {
                    iterationList.add(list.get(i));
                }
            }
        }
        //list.removeAll(iterationList);
        return iterationList.toArray();
    }

}
