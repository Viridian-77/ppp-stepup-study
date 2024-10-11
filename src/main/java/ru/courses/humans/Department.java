package ru.courses.humans;

public class Department {
    private String name;
    private Employee boss;

    public Department(String name, Employee boss) {
        this.name = name;
        setBossPrivate(boss);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        setBossPrivate(boss);
    }
    //Если назначаем босса из другого департамента, то меняем ему департамент на этот
    private void setBossPrivate(Employee boss) {
        this.boss = boss;
        if (boss.getDepartment() == null || boss.getDepartment() != this) boss.setDepartment(this);
    }
    //Проверяем на null, чтобы распечатать отдел в любом случае
    @Override
    public String toString() {
        return String.format("Отдел %s, босс: %s", name, boss == null ? null : boss.getName());
    }
}
