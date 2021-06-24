package data.classes;

public class People {

    private String name;
    private String job;

    public People(){
        super();
    }

    public People(String name, String job){
        this.job=job;
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setJob(String job) {
        this.job = job;
    }

}
