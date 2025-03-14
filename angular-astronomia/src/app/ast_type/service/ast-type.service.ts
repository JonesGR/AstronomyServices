import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { AstTypes } from "../model/ast_types";
import {AstTypeForm} from '../model/ast_type-form';
import {AstType} from '../model/ast_type';
import {AstTypeDetails} from '../model/ast_type-details';


@Injectable({
  providedIn: 'root'
})
export class AstTypeService {
  private apiUrl = 'localhost:8084/api/ast_types'; // Adres API gateway
  constructor(private http: HttpClient) { }

  getAstType(uuid: string): Observable<AstTypeDetails> {
    return this.http.get<AstTypeDetails>('/api/ast_types/'+uuid);
  }

  getAstTypes(): Observable<AstTypes> {
    return this.http.get<AstTypes>('api/ast_types');
  }

  deleteAstType(id: string): Observable<void> {
    return this.http.delete<void>('/api/ast_types/'+ id);
  }

  putAstType(id: string, request: AstTypeForm): Observable<any> {
    return this.http.put('/api/ast_types/' + id, request);
  }

}
