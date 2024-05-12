package metlife.team01.application.domain.postShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import metlife.team01.config.jpa.BaseTimeEntity;

import java.io.Serializable;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name="chat_code", schema = "chatmetlife")
public class CategoryDisplayEntity extends BaseTimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_num")
    private int codeNum;

    @Column(name = "menu_level")
    private int menuLevel;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "chat_response")
    private String chatResponse;

    @Column(name = "delete_yn")
    private String deleteYn;

    @Column(name = "parent_code_num")
    private Integer parentCodeNum;

    public CategoryDisplayEntity(int codeNum, int menuLevel, String codeName, String chatResponse, String createdAt, String modifyAt, String dltYn, Integer parentCodeNum) {
        this.codeNum = codeNum;
        this.menuLevel = menuLevel;
        this.codeName = codeName;
        this.chatResponse = chatResponse;
        this.deleteYn = dltYn;
        this.parentCodeNum = parentCodeNum;
    }

    public CategoryDisplayEntity(int menuLevel, String codeName, String chatResponse, String createdAt, String modifyAt, String dltYn, int parentCodeNum) {
        this.menuLevel = menuLevel;
        this.codeName = codeName;
        this.chatResponse = chatResponse;
        this.deleteYn = dltYn;
        this.parentCodeNum = parentCodeNum;
    }
}
