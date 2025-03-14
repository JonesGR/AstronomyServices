import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { CelestialBodies } from "../model/celestial_bodies";
import {CelestialBody} from '../model/celestial_body';
import {CelestialBodyDetails} from '../model/celestial_body-details';
import {CelestialBodyForm} from '../model/celestial_body-form';


@Injectable({
  providedIn: 'root'
})
export class CelestialBodyService {
  private apiUrl = 'localhost:8084/api/celestial_bodies'; // Adres API gateway
  constructor(private http: HttpClient) { }

  getCelestialBody(uuid: string): Observable<CelestialBodyDetails> {
    return this.http.get<CelestialBodyDetails>('/api/celestial_bodies/'+uuid);
  }

  getCelestialBodies(): Observable<CelestialBodies> {
    return this.http.get<CelestialBodies>('api/celestial_bodies');
  }

  deleteCelestialBody(id: string): Observable<void> {
    return this.http.delete<void>('/api/celestial_bodies/'+ id);
  }

  putCelestialBody(id: string, request: CelestialBodyForm): Observable<any> {
    return this.http.put('/api/celestial_bodies/' + id, request);
  }

  getAstTypesCelestialBodies(uuid: string): Observable<CelestialBodies> {
    return this.http.get<CelestialBodies>('api/ast_types/'+uuid+'/celestial_bodies')
  }

}
