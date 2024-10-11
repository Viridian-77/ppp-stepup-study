package ru.courses.humans;

public class Employee {
    private static final Employee noEmployee = new Employee("[Сотрудник не назначен]", null);
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(String name) {
        this(name, null);
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
                && this.department.getBoss() == this) {
            this.department.setBoss(noEmployee);
        }
        this.department = department;
    }
    //проверяем на null, чтобы сотрудника всегда можно было напечатать
    @Override
    public String toString() {
        String res;
        if (department != null && this == department.getBoss()) {
            res = String.format("%s начальник отдела %s", name, department.getName());
        } else {
            String depName = null;
            String depBossName = null;
            if (department != null) {
                depName = department.getName();
                if (department.getBoss() != null) {
                    depBossName = department.getBoss().getName();
                }
            }
            res = String.format("%s работает в отделе %s, начальником которого является %s", name, depName, depBossName);
        }
        return res;
    }
}
