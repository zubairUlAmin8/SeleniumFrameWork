/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package myweb.com.helpers;

import myweb.com.constants.FrameworkConstants;
import myweb.com.utils.Log;
import org.apache.commons.io.FileUtils;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CaptureHelpers  {

    // ------Record with Monte Media library---------
    private static ScreenRecorder screenRecorder;
    private static String name;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");


    public static void captureScreenshot(WebDriver driver, String screenName) {
        try {
            String path = Helpers.getCurrentDir() + FrameworkConstants.EXPORT_CAPTURE_PATH;
            File file = new File(path);
            if (!file.exists()) {
                Log.info("No Folder: " + path);
                file.mkdir();
                Log.info("Folder created: " + file);
            }

            Log.info("Driver for Screenshot: " + driver);
            // Tạo tham chiếu của TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            // Gọi hàm capture screenshot - getScreenshotAs
            File source = ts.getScreenshotAs(OutputType.FILE);
            // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
            FileUtils.copyFile(source, new File(path + "/" + screenName + "_" + dateFormat.format(new Date()) + ".png"));
            Log.info("Screenshot taken: " + screenName);
            Log.info("Screenshot taken current URL: " + driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }

}
