import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardWardensComponent } from './board-wardens/board-wardens.component';
import { ContactComponent } from './contact/contact.component';
import { CreateroomComponent } from './createroom/createroom.component';
import { DatareservationComponent } from './datareservation/datareservation.component';
import { DetailsComponent } from './details/details.component';
import { EditroomComponent } from './editroom/editroom.component';
import { GuestComponent } from './guest/guest.component';
import { HomeComponent } from './home/home.component';
import { InformationtotalComponent } from './informationtotal/informationtotal.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { ReservationComponent } from './reservation/reservation.component';
import { RoomComponent } from './room/room.component';
import { ViewroomComponent } from './viewroom/viewroom.component';

const routes: Routes = [

  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardWardensComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'room', component: RoomComponent },
  { path: 'guest', component: GuestComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'reservation/:roomId', component: ReservationComponent},
  { path: 'createroom', component: CreateroomComponent},
  { path: 'editroom/:roomId', component: EditroomComponent},
  { path: 'viewroom/:roomId', component: ViewroomComponent},
  { path: 'datareservation', component: DatareservationComponent},
  { path: 'details', component: DetailsComponent},
  { path: 'informationtotal', component: InformationtotalComponent},

  { path: '', redirectTo: 'home', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
