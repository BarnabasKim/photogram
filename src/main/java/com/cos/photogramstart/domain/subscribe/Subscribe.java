package com.cos.photogramstart.domain.subscribe;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(
						name="subscribe_uk",
						columnNames = {"fromUserId", "toUserId"}
						)
				
		}
		)
public class Subscribe {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다. 
		private int id;
		
		@JoinColumn(name="fromUserId") // 이렇게 컬럼명 만들어! 니 맘대로 만들지말고!!
		@ManyToOne
		private User fromUser; //구독하는유저 
		
		@JoinColumn(name="ToUserId")
		@ManyToOne
		private User toUser; //구독받는애 
		
		private LocalDateTime createDate;
		
		@PrePersist
		public void createDate() {
			this.createDate = LocalDateTime.now();
		}
		
}