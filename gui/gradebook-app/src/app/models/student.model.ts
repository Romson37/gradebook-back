import { Group } from "./group.model";

export class Student {
    studentId: number;
    name: string;
    surname: string;
    email: string;
    group: Group;
    
    constructor(studentId: number, name: string, surname: string, email: string, group: Group) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.group = group;
    }
}