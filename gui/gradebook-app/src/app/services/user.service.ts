import { Injectable, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Group } from '../models/group.model';
import { Student } from '../models/student.model';
import { Mark } from '../models/mark.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8080/userPanel';
  private teacherUrl = 'http://localhost:8080/teacherPanel';
  private pmUrl = 'http://localhost:8080/studentPanel';
  private adminUrl = 'http://localhost:8080/adminPanel';
  private studentListUrl = 'http://localhost:8080/teacherPanel/';
  private studentMarksTUrl = 'http://localhost:8080/teacherPanel/';
  private studentAddMarkUrl = 'http://localhost:8080/teacherPanel/';
  constructor(private http: HttpClient) { }

  addMark(id: number, mark: Mark) {
    return this.http.post(this.studentAddMarkUrl + id + '/addMark', mark);
  }
 
  getStudentsMarksTBoard(studentId: number): Observable<Mark[]> {
    return this.http.get<Mark[]>(this.studentMarksTUrl + studentId + '/studentsMarks');
  }
  getStudentListBoard(groupId: string): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentListUrl + groupId + '/studentsList');
  }
  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }
  getTeacherBoard(): Observable<Group[]> {
    return this.http.get<Group[]>(this.teacherUrl);
  }
  getStudentBoard(): Observable<string> {
    return this.http.get(this.pmUrl, { responseType: 'text' });
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }
}
