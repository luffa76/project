package edu.pusan.example.board.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import edu.pusan.example.user.domain.User;
import lombok.Data;

@Data
@Entity(name = "tb_board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardId;
    private String title;
    private String contents;
    @CreationTimestamp
	@Column(name = "insert_date")
	private LocalDateTime insertDate;
    @UpdateTimestamp
	@Column(name = "update_date")
	private LocalDateTime updateDate;
    private String used;

    @OneToOne
    @JoinColumn(name = "writer_id")
    private User writer;
}
