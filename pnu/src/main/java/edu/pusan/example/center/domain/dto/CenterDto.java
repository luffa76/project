package edu.pusan.example.center.domain.dto;

import java.time.LocalDateTime;
import java.util.Date;

import edu.pusan.example.center.domain.Center;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CenterDto {
    private Integer centerId;
    private String title;
    private String contents;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;
    private String used;
    private String writerId;
    private String writerName;

    public Center build(){
        Center center = new Center();
        center.setTitle(title);
        center.setContents(contents);
        center.setInsertDate(insertDate);
        center.setUsed(used);

        return center;
    }
}
