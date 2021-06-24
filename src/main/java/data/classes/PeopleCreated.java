package data.classes;

public class PeopleCreated extends People{

    private Integer id;
    private String createdAt;

    public PeopleCreated(){
        super();
    }

    public PeopleCreated(String name, String job, Integer id, String createdAt){
        super(name,job);
        this.id=id;
        this.createdAt=createdAt;
    }

    public Integer getId() {
        return id;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public String getName(){
        return super.getName();
    }
    public String getJob(){
        return super.getJob();
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        super.setName(name);
    }
    public void setJob(String job) {
        super.setJob(job);
    }

}
