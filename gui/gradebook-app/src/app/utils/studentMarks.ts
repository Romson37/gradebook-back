import { Student } from "../models/student.model";
import { Mark } from '../models/mark.model';

export class StudentMarks {

    student: Student;
    marks: Mark[];

    constructor(student: Student, marks: Mark[]){
        this.student=student;
        this.marks=marks;
    }

    
}