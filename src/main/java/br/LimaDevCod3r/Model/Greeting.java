package br.LimaDevCod3r.Model;

public class Greeting {
    private  Long id;

    private String context;

    public Greeting(Long id, String context) {
        this.id = id;
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public String getContext() {
        return context;
    }
}
