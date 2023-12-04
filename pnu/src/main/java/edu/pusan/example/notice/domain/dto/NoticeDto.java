package edu.pusan.example.notice.domain.dto;

import java.util.Date;

import edu.pusan.example.notice.domain.Notice;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoticeDto {
    private int noticeId;
    private String noticetitle;
    private String noticecontents;
    private Date noticeinsertDate;
    private String noticeused;
    private String writerId;
    private String writerName;

    public Notice build(){
        Notice notice = new Notice();
        notice.setNoticeId(noticeId);
        notice.setNoticetitle(noticetitle);
        notice.setNoticecontents(noticecontents);
        notice.setNoticeinsertDate(noticeinsertDate);
        notice.setNoticeused(noticeused);
        return notice;
    }
}
