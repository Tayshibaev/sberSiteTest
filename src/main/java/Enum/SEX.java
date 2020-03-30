package Enum;

public enum SEX {
    МУЖСКОЙ("Мужской"),
    ЖЕНСКИЙ("Женский");

    private String sex;

    SEX(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
