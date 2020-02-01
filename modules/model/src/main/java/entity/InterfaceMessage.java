package entity;

public class InterfaceMessage {

    private Boolean successful;
    private String message;
    private String token;

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }
}
