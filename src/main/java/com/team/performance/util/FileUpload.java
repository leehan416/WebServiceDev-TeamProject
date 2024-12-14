package com.team.performance.util;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.performance.VO.PerformanceVO;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class FileUpload {
    public PerformanceVO uploadFile(HttpServletRequest request) {
        int sizeLimit = 15 * 1024 * 1024; // File size limit: 15MB

        // Retrieve upload path relative to the application context
        String realPath = request.getServletContext().getRealPath("/upload");
        System.out.println("Upload path: " + realPath);

        // Create upload directory if it doesn't exist
        File dir = new File(realPath);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Upload directory created successfully.");
            } else {
                System.out.println("Failed to create upload directory.");
                return null;
            }
        }

        MultipartRequest multipartRequest = null;
        try {
            // Create MultipartRequest
            multipartRequest = new MultipartRequest(
                    request,
                    realPath,
                    sizeLimit,
                    "utf-8",
                    new DefaultFileRenamePolicy() // Handle duplicate filenames
            );
        } catch (IOException e) {
            System.out.println("Error during file upload!");
            e.printStackTrace();
            return null;
        }

        // Retrieve uploaded file and form data
        String posterFile = multipartRequest.getFilesystemName("posterFile");
        String title = multipartRequest.getParameter("title");
        String currentNumStr = multipartRequest.getParameter("currentNum");
        String maxNumStr = multipartRequest.getParameter("maxNum");
        String performanceDate = multipartRequest.getParameter("performanceDate");
        String content = multipartRequest.getParameter("content");

        if (posterFile == null || title == null || currentNumStr == null || maxNumStr == null || performanceDate == null || content == null) {
            System.out.println("Error: Missing required fields or file.");
            return null;
        }

        int currentNum = Integer.parseInt(currentNumStr);
        int maxNum = Integer.parseInt(maxNumStr);

        // Populate PerformanceVO
        PerformanceVO performanceVO = new PerformanceVO();
        performanceVO.setPosterFile("/upload/" + posterFile); // Store relative path
        performanceVO.setTitle(title);
        performanceVO.setCurrentNum(currentNum);
        performanceVO.setMaxNum(maxNum);
        performanceVO.setPerformanceDate(Timestamp.valueOf(performanceDate + " 00:00:00"));
        performanceVO.setContent(content);

        return performanceVO;
    }
}