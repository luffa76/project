package edu.pusan.example.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pusan.example.notice.domain.Notice;
import edu.pusan.example.notice.domain.dto.NoticeDto;
import edu.pusan.example.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public List<NoticeDto> getNoticeList() {
        List<Notice> noticeList=noticeRepository.findAll();
        ArrayList<NoticeDto> result= new ArrayList<NoticeDto>();

        for (Notice notice : noticeList) {
            NoticeDto temp = NoticeDto.builder()
                                      .noticeId(notice.getNoticeId())
                                      .noticetitle(notice.getNoticetitle())
                                      .noticecontents(notice.getNoticecontents())
                                      .noticeinsertDate(notice.getNoticeinsertDate())
                                      .noticeused(notice.getNoticeused())
                                      .writerId(notice.getWriter().getUserId())
                                      .writerName(notice.getWriter().getName())
                                      .build();
            result.add(temp);
        }
        return null;
    }

}
