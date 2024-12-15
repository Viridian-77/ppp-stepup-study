package ru.courses.humans;

public class Department {
    String name;
    Employee boss;

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
        if (boss.department == null || boss.department != this) boss.department = this;
    }
    //Проверяем на null, чтобы распечатать отдел в любом случае
    @Override
    public String toString() {
        return String.format("Отдел %s, босс: %s", name, boss == null ? null : boss.name);
    }
}
