package ru.courses.humans;

public class Employee {
    static final Employee noEmployee = new Employee("[Сотрудник не назначен]", null);
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }
    //Если босс меняет отдел, его бывший отдел остается без босса
    public void setDepartment(Department department) {
        if (this.department != null
                && this.department != department
                && this.department.boss == this) {
            this.department.boss = noEmployee;
        }
        this.department = department;
    }
    //проверяем на null, чтобы сотрудника всегда можно было напечатать
    @Override
    public String toString() {
        String res;
        if (department != null && this == department.boss) {
            res = String.format("%s начальник отдела %s", name, department.name);
        } else {
            String depName = null;
            String depBossName = null;
            if (department != null) {
                depName = department.name;
                if (department.boss != null) {
                    depBossName = department.boss.name;
                }
            }
            res = String.format("%s работает в отделе %s, начальником которого является %s", name, depName, depBossName);
        }
        return res;
    }
}
