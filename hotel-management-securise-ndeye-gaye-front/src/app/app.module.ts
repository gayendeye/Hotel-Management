import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardWardensComponent } from './board-wardens/board-wardens.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { ProfileComponent } from './profile/profile.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { RoomComponent } from './room/room.component';
import { ContactComponent } from './contact/contact.component';
import { ReservationComponent } from './reservation/reservation.component';
import { GuestComponent } from './guest/guest.component';
import { FooterComponent } from './footer/footer.component';
import { CreateroomComponent } from './createroom/createroom.component';
import { EditroomComponent } from './editroom/editroom.component';
import { DatareservationComponent } from './datareservation/datareservation.component';
import { ViewroomComponent } from './viewroom/viewroom.component';
import { DetailsComponent } from './details/details.component';
import { InformationtotalComponent } from './informationtotal/informationtotal.component';
import { NgxPaginationModule } from 'ngx-pagination';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    BoardAdminComponent,
    BoardWardensComponent,
    BoardUserComponent,
    ProfileComponent,
    NavbarComponent,
    AccueilComponent,
    RoomComponent,
    ContactComponent,
    ReservationComponent,
    GuestComponent,
    FooterComponent,
    CreateroomComponent,
    EditroomComponent,
    DatareservationComponent,
    ViewroomComponent,
    DetailsComponent,
    InformationtotalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPaginationModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
