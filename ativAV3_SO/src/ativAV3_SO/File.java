package ativAV3_SO;

import java.util.Date;

public class File {
    private String name;
    private String content;
    private Date created;
    private Date modified;

    public File(String name) {
        this.name = name;
        this.content = "";
        this.created = new Date();
        this.modified = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.modified = new Date();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.modified = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }
}


