package com.team.performance.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceVO {
    private Integer id;               // Performance ID
    private String title;             // Performance title
    private Integer currentNum;       // Current number of participants
    private Integer maxNum;           // Maximum number of participants
    private Timestamp performanceDate;// Performance date
    private Timestamp regDate;        // Registration date
    private String posterFile;        // Poster file path or URL
    private String content;           // Performance description/content
    private Integer writer_id;        // writer
}
