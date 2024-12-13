package com.team.performance.util;

import com.team.performance.VO.PerformanceVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class FileUpload {

    public PerformanceVO uploadFile(HttpServletRequest request) {
        int sizeLimit = 15 * 1024 * 1024; // File size limit: 15MB
        String realPath = request.getServletContext().getRealPath("/upload"); // Upload folder path
        System.out.println("Upload path: " + realPath);

        // Create upload directory if it doesn't exist
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        MultipartRequest multipartRequest;
        try {
            multipartRequest = new MultipartRequest(
                    request,
                    realPath,
                    sizeLimit,
                    "UTF-8",
                    new DefaultFileRenamePolicy()
            );
        } catch (IOException e) {
            System.out.println("Error during file upload!");
            e.printStackTrace();
            return null;
        }

        // Get uploaded file and form data
        String posterFile = multipartRequest.getFilesystemName("posterFile");
        String title = multipartRequest.getParameter("title");
        int currentNum = Integer.parseInt(multipartRequest.getParameter("currentNum"));
        int maxNum = Integer.parseInt(multipartRequest.getParameter("maxNum"));
        String performanceDate = multipartRequest.getParameter("performanceDate");
        String content = multipartRequest.getParameter("content");

        // Populate PerformanceVO
        PerformanceVO performanceVO = new PerformanceVO();
        performanceVO.setPosterFile("/upload/" + posterFile);
        performanceVO.setTitle(title);
        performanceVO.setCurrentNum(currentNum);
        performanceVO.setMaxNum(maxNum);

        // Convert performanceDate to java.sql.Timestamp
        try {
            performanceVO.setPerformanceDate(Timestamp.valueOf(performanceDate + " 00:00:00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format: " + performanceDate);
            e.printStackTrace();
            return null;
        }

        performanceVO.setContent(content);

        return performanceVO;
    }
}