package metlife.team01.application.util;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ResponseMessage implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "요청 처리 결과 Object",
            required = false
    )
    Object item;
    @ApiModelProperty(
            value = "처리 상태 코드는 resultCode 로 변경되어 추후 삭제 해야함, Response Status Code 정리전 개발 Repository 오류로 인해 넣어둠",
            required = false,
            example = "200"
    )
    int statusCode;
    @ApiModelProperty(
            value = "처리 상태 코드",
            required = false,
            example = "정상처리 되었습니다."
    )
    String resultCode;
    @ApiModelProperty(
            value = "처리 결과 메세지",
            required = false,
            example = "정상처리 되었습니다."
    )
    String resultMessage;
    @ApiModelProperty(
            value = "처리 결과 상세 메세지",
            required = false,
            example = "처리중 오류 발생시 상세 메세지 노출."
    )
    String detailMessage;

    protected ResponseMessage(final ResponseMessageBuilder<?, ?> b) {
        this.item = b.item;
        this.statusCode = b.statusCode;
        this.resultCode = b.resultCode;
        this.resultMessage = b.resultMessage;
        this.detailMessage = b.detailMessage;
    }

    public static ResponseMessageBuilder<?, ?> builder() {
        return new ResponseMessageBuilderImpl();
    }

    public Object getItem() {
        return this.item;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public void setItem(final Object item) {
        this.item = item;
    }

    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    public void setResultCode(final String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMessage(final String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setDetailMessage(final String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseMessage)) {
            return false;
        } else {
            ResponseMessage other = (ResponseMessage)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatusCode() != other.getStatusCode()) {
                return false;
            } else {
                label61: {
                    Object this$item = this.getItem();
                    Object other$item = other.getItem();
                    if (this$item == null) {
                        if (other$item == null) {
                            break label61;
                        }
                    } else if (this$item.equals(other$item)) {
                        break label61;
                    }

                    return false;
                }

                label54: {
                    Object this$resultCode = this.getResultCode();
                    Object other$resultCode = other.getResultCode();
                    if (this$resultCode == null) {
                        if (other$resultCode == null) {
                            break label54;
                        }
                    } else if (this$resultCode.equals(other$resultCode)) {
                        break label54;
                    }

                    return false;
                }

                Object this$resultMessage = this.getResultMessage();
                Object other$resultMessage = other.getResultMessage();
                if (this$resultMessage == null) {
                    if (other$resultMessage != null) {
                        return false;
                    }
                } else if (!this$resultMessage.equals(other$resultMessage)) {
                    return false;
                }

                Object this$detailMessage = this.getDetailMessage();
                Object other$detailMessage = other.getDetailMessage();
                if (this$detailMessage == null) {
                    if (other$detailMessage != null) {
                        return false;
                    }
                } else if (!this$detailMessage.equals(other$detailMessage)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseMessage;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getStatusCode();
        Object $item = this.getItem();
        result = result * 59 + ($item == null ? 43 : $item.hashCode());
        Object $resultCode = this.getResultCode();
        result = result * 59 + ($resultCode == null ? 43 : $resultCode.hashCode());
        Object $resultMessage = this.getResultMessage();
        result = result * 59 + ($resultMessage == null ? 43 : $resultMessage.hashCode());
        Object $detailMessage = this.getDetailMessage();
        result = result * 59 + ($detailMessage == null ? 43 : $detailMessage.hashCode());
        return result;
    }

    public String toString() {
        Object var10000 = this.getItem();
        return "ResponseMessage(item=" + var10000 + ", statusCode=" + this.getStatusCode() + ", resultCode=" + this.getResultCode() + ", resultMessage=" + this.getResultMessage() + ", detailMessage=" + this.getDetailMessage() + ")";
    }

    public ResponseMessage() {
    }

    public ResponseMessage(final Object item, final int statusCode, final String resultCode, final String resultMessage, final String detailMessage) {
        this.item = item;
        this.statusCode = statusCode;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.detailMessage = detailMessage;
    }

    private static final class ResponseMessageBuilderImpl extends ResponseMessageBuilder<ResponseMessage, ResponseMessageBuilderImpl> {
        private ResponseMessageBuilderImpl() {
        }

        protected ResponseMessageBuilderImpl self() {
            return this;
        }

        public ResponseMessage build() {
            return new ResponseMessage(this);
        }
    }

    public abstract static class ResponseMessageBuilder<C extends ResponseMessage, B extends ResponseMessageBuilder<C, B>> {
        private Object item;
        private int statusCode;
        private String resultCode;
        private String resultMessage;
        private String detailMessage;

        public ResponseMessageBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B item(final Object item) {
            this.item = item;
            return this.self();
        }

        public B statusCode(final int statusCode) {
            this.statusCode = statusCode;
            return this.self();
        }

        public B resultCode(final String resultCode) {
            this.resultCode = resultCode;
            return this.self();
        }

        public B resultMessage(final String resultMessage) {
            this.resultMessage = resultMessage;
            return this.self();
        }

        public B detailMessage(final String detailMessage) {
            this.detailMessage = detailMessage;
            return this.self();
        }

        public String toString() {
            return "ResponseMessage.ResponseMessageBuilder(item=" + this.item + ", statusCode=" + this.statusCode + ", resultCode=" + this.resultCode + ", resultMessage=" + this.resultMessage + ", detailMessage=" + this.detailMessage + ")";
        }
    }
}