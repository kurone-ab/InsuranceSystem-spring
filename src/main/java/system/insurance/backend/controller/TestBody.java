package system.insurance.backend.controller;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class TestBody {
    private final int id;
    private final String title;
    private final String auth;
    private final String date;

    public TestBody(int id, String title, String auth, String date) {
        this.id = id;
        this.title = title;
        this.auth = auth;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuth() {
        return auth;
    }

    public String getDate() {
        return date;
    }
}
