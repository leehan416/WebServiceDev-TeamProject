package com.team.performance.service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.performance.VO.PerformanceVO;
import com.team.performance.mapper.PerformanceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

@Service
@Slf4j
public class PerformanceService {

    @Autowired
    private PerformanceMapper performanceMapper;


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

        if (title == null || maxNumStr == null || performanceDate == null || content == null) {
            System.out.println("Error: Missing required fields.");
            return null;
        }

        // remove stored file
        if (idStr != null) {


            String storedFilename = getPerformanceById(Integer.valueOf(idStr)).getPosterFile();
//            String oldFilePath = request.getServletContext().getRealPath(storedFilename);
            File oldFile = new File(storedFilename);
            if (oldFile.exists()) oldFile.delete();
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


    // Retrieve all performances
    public List<PerformanceVO> getAllPerformances(String sorted) {
        log.info("Fetching all performances.");
        List<PerformanceVO> performances = new ArrayList<>();
        if (sorted == null)
            performances = performanceMapper.getAllPerformances();
        else if (sorted.equals("date"))
            performances = performanceMapper.getPerformancesOrderByDate();
        else if (sorted.equals("title"))
            performances = performanceMapper.getPerformancesOrderByTitle();
        return performances;
    }

    // Retrieve a specific performance by ID
    public PerformanceVO getPerformanceById(Integer id) {
        log.info("Fetching performance with ID: {}", id);
        PerformanceVO performance = performanceMapper.getPerformanceById(id);
        if (performance != null) {
            log.info("Performance title: {}", performance.getTitle());
        } else {
            log.warn("No performance found with ID: {}", id);
        }
        return performance;
    }

    // Insert a new performance
    public void addPerformance(PerformanceVO performance) {
//        log.info("Adding new performance: {}", performance);
        performanceMapper.insertPerformance(performance);
        log.info("Performance added successfully.");
    }

    // Delete a performance by ID
    public void deletePerformanceById(Integer id) {
        log.info("Deleting performance with ID: {}", id);
        performanceMapper.deletePerformanceById(id);
        log.info("Performance deleted successfully.");
    }

    // Update an existing performance
    public void updatePerformance(PerformanceVO performance) {
        log.info("Updating performance with ID: {}", performance.getId());
        performanceMapper.updatePerformance(performance);
        log.info("Performance updated successfully.");
    }

    public List<PerformanceVO> getPerformancesByText(String text) {
        List<PerformanceVO> performances = performanceMapper.getPerformancesByText(text);

        return performances;


    }
}