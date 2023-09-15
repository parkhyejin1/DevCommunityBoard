package com.example.demo.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="boardNo")
@ToString

@Entity
@Table(name="board")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;
	
	@NotBlank
	@Column(length=200,nullable=false)
	private String title;
	
	@NotBlank
	@Column(length=50,nullable=false)
	private String writer;
	
	@Lob
	private String content;
//	@Column(length=50,nullable=false)
//	private String type;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
}
