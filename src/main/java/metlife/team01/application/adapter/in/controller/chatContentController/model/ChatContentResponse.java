package metlife.team01.application.adapter.in.controller.chatContentController.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
public class ChatContentResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private int chatNum;
    private String roomId;
    private String content;
    private String codeNum;
    private String createdAt;
    private String modifyAt;
    private String deleteYn;
//
//    @QueryProjection
//    public ChatContentResponse(int chatNum, String roomId, String content, String codeNum, String createdAt, String modifyAt, String deleteYN) {
//        this.chatNum = chatNum;
//        this.roomId = roomId;
//        this.content = content;
//        this.codeNum = codeNum;
//        this.createdAt = createdAt;
//        this.modifyAt = modifyAt;
//        this.deleteYN = deleteYN;
//    }
}
