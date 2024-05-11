package metlife.team01.application.domain.chatContent.model;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import metlife.team01.config.jpa.BaseTimeEntity;

import java.io.Serializable;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "chat_content_m", schema = "chatmetlife")
public class ChatContentEntity extends BaseTimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_num")
    private int chatNum;

    @Column(name="room_id")
    private String roomId;

    @Column(name = "content")
    private String content;

    @Column(name = "code_num")
    private String codeNum;

    @Column(name = "delete_yn")
    private String deleteYn;

    public ChatContentEntity(String roomId, String content, String codeNum, String deleteYn) {
        this.roomId = roomId;
        this.content = content;
        this.codeNum = codeNum;
        this.deleteYn = deleteYn;
    }
}
