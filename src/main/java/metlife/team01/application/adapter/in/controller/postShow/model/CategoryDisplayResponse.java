package metlife.team01.application.adapter.in.controller.postShow.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import metlife.team01.application.domain.postShow.model.CategoryDisplayEntity;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
public class CategoryDisplayResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private int codeNum;
    private int menuLevel;
    private String codeName;
    private String chatResponse;
    private String deleteYn;
    private Integer parentCodeNum;

    @QueryProjection
    public CategoryDisplayResponse(CategoryDisplayEntity categoryDisplayEntity, Integer menuLevel) {
        this.codeNum = categoryDisplayEntity.getCodeNum();
        this.menuLevel = menuLevel;
        this.codeName = categoryDisplayEntity.getCodeName();
        this.chatResponse = categoryDisplayEntity.getChatResponse();
        this.deleteYn = categoryDisplayEntity.getDeleteYn();
        this.parentCodeNum = categoryDisplayEntity.getParentCodeNum();
    }

    @QueryProjection
    public CategoryDisplayResponse(CategoryDisplayEntity categoryDisplayEntity, Integer parentCodeNum, Integer menuLevel) {
        this.codeNum = categoryDisplayEntity.getCodeNum();
        this.menuLevel = menuLevel;
        this.codeName = categoryDisplayEntity.getCodeName();
        this.chatResponse = categoryDisplayEntity.getChatResponse();
        this.deleteYn = categoryDisplayEntity.getDeleteYn();
        this.parentCodeNum = parentCodeNum;
    }

    @QueryProjection
    public CategoryDisplayResponse(CategoryDisplayEntity categoryDisplayEntity, String codeName) {
        this.codeNum = categoryDisplayEntity.getCodeNum();
        this.menuLevel = categoryDisplayEntity.getMenuLevel();
        this.codeName = codeName;
        this.chatResponse = categoryDisplayEntity.getChatResponse();
        this.deleteYn = categoryDisplayEntity.getDeleteYn();
        this.parentCodeNum = categoryDisplayEntity.getParentCodeNum();
    }

    public CategoryDisplayResponse(String chatResponse) {
        this.chatResponse = chatResponse;
    }
}
