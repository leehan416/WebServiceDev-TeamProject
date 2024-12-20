package com.team.performance.util;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.performance.VO.PerformanceVO;
import com.team.user.VO.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FileUpload {
    public PerformanceVO uploadFile(HttpServletRequest request, Integer writer_id) {
        int sizeLimit = 15 * 1024 * 1024; // File size limit: 15MB

        String realPath = request.getServletContext().getRealPath("./WEB-INF/views/upload");



        File dir = new File(realPath);

        if (!dir.exists()) dir.mkdirs();

        MultipartRequest multipartRequest;
        try {
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());


        } catch (IOException e) {
            //error
            return null;
        }


        // Retrieve uploaded file and form data
        String idStr = multipartRequest.getParameter("id"); // Retrieve ID for edit
        String posterFile = multipartRequest.getFilesystemName("posterFile");
        String title = multipartRequest.getParameter("title");
//        String currentNumStr = multipartRequest.getParameter("currentNum");
        String maxNumStr = multipartRequest.getParameter("maxNum");
        String performanceDate = multipartRequest.getParameter("performanceDate");
        String content = multipartRequest.getParameter("content");

        if (title == null ||maxNumStr == null || performanceDate == null || content == null) {
            System.out.println("Error: Missing required fields.");
            return null;
        }


        // Parse numeric and date fields
        Integer id = (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : null;
        int maxNum = Integer.parseInt(maxNumStr);

        // Populate PerformanceVO
        PerformanceVO performanceVO = new PerformanceVO();
        performanceVO.setId(id); // Set ID if available
//        performanceVO.setPosterFile(posterFile != null ? "/upload/" + posterFile : null); // Set relative file path
        performanceVO.setTitle(title);
        performanceVO.setCurrentNum(0);
        performanceVO.setMaxNum(maxNum);
        performanceVO.setPerformanceDate(Timestamp.valueOf(performanceDate + " 00:00:00"));
        performanceVO.setContent(content);

        String originalFileName = multipartRequest.getOriginalFileName("posterFile");
        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String savedFileName = uuid + ext;

        File originalFile = new File(realPath + File.separator + multipartRequest.getFilesystemName("posterFile"));
        File newFile = new File(realPath + File.separator + savedFileName);
        originalFile.renameTo(newFile);

        performanceVO.setPosterFile(posterFile != null ? "/upload/" + savedFileName : null);


        ////////////////////////
        performanceVO.setWriter_id(writer_id);
        ////////////////////////


        return performanceVO;
    }
}