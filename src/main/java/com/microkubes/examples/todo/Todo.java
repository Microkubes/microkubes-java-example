package com.microkubes.examples.todo;

public class Todo {
    private String id;
    private String title;
    private String content;
    private Long timestamp;
    private String owner;

    public Todo() {

    }

    public Todo(String id, String title, String content, Long timestamp, String owner) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Todo todo = (Todo) object;
        return java.util.Objects.equals(id, todo.id);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
