import { Group } from "./group.model";

export class Teacher {
    teacherId: number;
    name: string;
    surname: string;
    email: string;
    subject: string;
    groups: Group[] = [];

    constructor(teacherId: number, name: string, surname: string, email: string, subject: string, groups: Group[]) {
        this.teacherId = teacherId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.subject = subject;
        this.groups = groups;
    }
}