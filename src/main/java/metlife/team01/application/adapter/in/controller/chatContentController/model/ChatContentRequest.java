package metlife.team01.application.adapter.in.controller.chatContentController.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ChatContentRequest {
    private int chatNum;
    private String roomId;
    private String content;
    private String codeNum;
    private String createdAt;
    private String modifyAt;
    private String deleteYn;

    private int parentCodeNum;



}
