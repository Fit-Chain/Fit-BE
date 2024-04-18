package com.hanghae99.fitchain_be.domain.entity;

import com.hanghae99.fitchain_be.domain.post.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    @Size(min = 1, message = "제목을 입력해주세요.")
    private String title;
    @Lob
    @Size(min = 1, message = "내용을 입력해주세요.")
    private String description;
    @Column
    private int likecnt;
    @Column
    private int viewCount;


//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
//    private User user;

    public Post(PostRequestDto postRequestDto) {

        this.title = postRequestDto.getTitle();
        this.description = postRequestDto.getDescription();

    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.description = postRequestDto.getDescription();
    }

}
