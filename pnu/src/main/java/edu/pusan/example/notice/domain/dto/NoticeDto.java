package edu.pusan.example.notice.domain.dto;

import java.util.Date;

import edu.pusan.example.notice.domain.Notice;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoticeDto {
    private int noticeId;
    private String noticeTitle;
    private String noticeContents;
    private Date noticeInsertDate;
    private String noticeUsed;
    private String writerId;
    private String writerName;

    public Notice build(){
        Notice notice = new Notice();
        notice.setNoticeId(noticeId);
        notice.setNoticeTitle(noticeTitle);
        notice.setNoticeContents(noticeContents);
        notice.setNoticeInsertDate(noticeInsertDate);
        notice.setNoticeUsed(noticeUsed);
        return notice;
    }
}
