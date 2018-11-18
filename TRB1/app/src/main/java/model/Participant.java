package model;

public class Participant {

    private int id;
    private String name;
    private String mail;
    private String registerNumber;

    public Participant(int id, String registerNumber, String name, String mail){
        setId(id);
        setName(name);
        setMail(mail);
        setRegisterNumber(registerNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
