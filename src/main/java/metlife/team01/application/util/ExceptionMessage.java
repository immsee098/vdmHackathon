package metlife.team01.application.util;

public class ExceptionMessage {
    private String resultCode;
    private String resultMessage;
    private int detailCode;
    private String detailMessage;

    public static ExceptionMessageBuilder builder() {
        return new ExceptionMessageBuilder();
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public int getDetailCode() {
        return this.detailCode;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public void setResultCode(final String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMessage(final String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setDetailCode(final int detailCode) {
        this.detailCode = detailCode;
    }

    public void setDetailMessage(final String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ExceptionMessage)) {
            return false;
        } else {
            ExceptionMessage other = (ExceptionMessage)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getDetailCode() != other.getDetailCode()) {
                return false;
            } else {
                label49: {
                    Object this$resultCode = this.getResultCode();
                    Object other$resultCode = other.getResultCode();
                    if (this$resultCode == null) {
                        if (other$resultCode == null) {
                            break label49;
                        }
                    } else if (this$resultCode.equals(other$resultCode)) {
                        break label49;
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
        return other instanceof ExceptionMessage;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getDetailCode();
        Object $resultCode = this.getResultCode();
        result = result * 59 + ($resultCode == null ? 43 : $resultCode.hashCode());
        Object $resultMessage = this.getResultMessage();
        result = result * 59 + ($resultMessage == null ? 43 : $resultMessage.hashCode());
        Object $detailMessage = this.getDetailMessage();
        result = result * 59 + ($detailMessage == null ? 43 : $detailMessage.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getResultCode();
        return "ExceptionMessage(resultCode=" + var10000 + ", resultMessage=" + this.getResultMessage() + ", detailCode=" + this.getDetailCode() + ", detailMessage=" + this.getDetailMessage() + ")";
    }

    public ExceptionMessage() {
    }

    public ExceptionMessage(final String resultCode, final String resultMessage, final int detailCode, final String detailMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.detailCode = detailCode;
        this.detailMessage = detailMessage;
    }

    public static class ExceptionMessageBuilder {
        private String resultCode;
        private String resultMessage;
        private int detailCode;
        private String detailMessage;

        ExceptionMessageBuilder() {
        }

        public ExceptionMessageBuilder resultCode(final String resultCode) {
            this.resultCode = resultCode;
            return this;
        }

        public ExceptionMessageBuilder resultMessage(final String resultMessage) {
            this.resultMessage = resultMessage;
            return this;
        }

        public ExceptionMessageBuilder detailCode(final int detailCode) {
            this.detailCode = detailCode;
            return this;
        }

        public ExceptionMessageBuilder detailMessage(final String detailMessage) {
            this.detailMessage = detailMessage;
            return this;
        }

        public ExceptionMessage build() {
            return new ExceptionMessage(this.resultCode, this.resultMessage, this.detailCode, this.detailMessage);
        }

        public String toString() {
            return "ExceptionMessage.ExceptionMessageBuilder(resultCode=" + this.resultCode + ", resultMessage=" + this.resultMessage + ", detailCode=" + this.detailCode + ", detailMessage=" + this.detailMessage + ")";
        }
    }
}