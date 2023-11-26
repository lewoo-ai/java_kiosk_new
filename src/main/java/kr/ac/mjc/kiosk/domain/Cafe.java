package kr.ac.mjc.kiosk.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateAt;


    @Builder
    public Article(String title,String content) {
        this.title=title;
        this.content=content;
    }


    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getFormattedCreateDate(){
        if(createdAt==null){
            return "";
        }
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm");
        return createdAt.format(pattern);
    }

}