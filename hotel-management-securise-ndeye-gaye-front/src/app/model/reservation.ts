import { Guest } from "./guest";
import { Room } from "./room";

export class Reservation {

    reservationId !: number;

    dateInn !: string;

    dateOut!: string;

    numberPerson !: number;

    room !: Room;

    guest !: Guest;

}
