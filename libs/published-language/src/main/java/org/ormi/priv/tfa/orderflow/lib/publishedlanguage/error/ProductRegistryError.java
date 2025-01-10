package org.ormi.priv.tfa.orderflow.lib.publishedlanguage.error;

import org.ormi.priv.tfa.orderflow.lib.publishedlanguage.message.ProductRegistryMessage;

class ProductRegistryError implements ProductRegistryMessage{
    public final String message;
    public final String errorCode;

    public ProductRegistryError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "ProductRegistryError{" +
                "message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductRegistryError that = (ProductRegistryError) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return errorCode != null ? errorCode.equals(that.errorCode) : that.errorCode == null;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        return result;
    }
}