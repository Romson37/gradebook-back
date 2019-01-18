import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private groupsUrl = "/teacherPanel"
  constructor() { }
}
