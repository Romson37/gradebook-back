import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AdminBoardComponent } from './admin-board/admin-board.component';
import { TeacherBoardComponent } from './teacher-board/teacher-board.component';
import { StudentListComponent } from './student-list/student-list.component';
 
const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'admin',
        component: AdminBoardComponent
    },
    {
        path: 'teacher',
        component: TeacherBoardComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'teacher/:id',
        component: StudentListComponent
    },
    
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];
 
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }