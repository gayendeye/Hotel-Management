import { Reservation } from "./reservation";
import { Room } from "./room";

export class Guest {

    guestId !: number;
    firstName !: string;
    lastName !: string;
    email !: string;
    numberPhone !: string;
    address !: string;
    city !: string;
    country !: string;

    room!: Room;

    reservation !: Reservation;


    

}
