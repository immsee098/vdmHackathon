package metlife.team01.application.domain.categoryDisplay.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryDisplayEntityTest {

    @Test
    @DisplayName("엔티티 생성")
    void create() {
        Assertions.assertDoesNotThrow(
                () -> new CategoryDisplayEntity(
                        1,
                        "보험",
                        "chatResponse",
                        "2024-03-23 20:47:19",
                        "2024-03-23 20:47:19",
                        null,
                        2));
    }
}
