package system.insurance.backend.employee;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ResponseEmployee {
    private final int id;
    private final String name;
    private final String authority;
    private final String error;

    public ResponseEmployee(int id, String name, String authority) {
        this.id = id;
        this.name = name;
        this.authority = authority;
        this.error = "no";
    }

    public ResponseEmployee(String error) {
        this.id = -1;
        this.name = "";
        this.authority = "";
        this.error = error;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthority() {
        return authority;
    }

    public String getError() {
        return error;
    }
}
