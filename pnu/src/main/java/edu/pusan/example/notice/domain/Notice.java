package edu.pusan.example.notice.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.pusan.example.user.domain.User;
import lombok.Data;

@Data
@Entity(name = "tb_notice")
public class Notice {
    @Id
    private int noticeId;
    private String noticetitle;
    private String noticecontents;
    private Date noticeinsertDate;
    private String noticeused;

    @OneToOne
    @JoinColumn(name="writer_id")
    private User writer;

}
