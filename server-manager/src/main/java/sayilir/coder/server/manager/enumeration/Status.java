package sayilir.coder.server.manager.enumeration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");
    private final String status;

    public String getStatus() {
        return status;
    }
}
