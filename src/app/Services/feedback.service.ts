import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from 'app/Feedback';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private apiServerUrl = environment.apiUrl; 

  constructor(private http : HttpClient) { }
  public getAllFeedbacks(): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.apiServerUrl}/feedback/getall`);
  }
  public deleteFeedbackById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/feedback/delete/${id}`);
  }
  public getFeedbackById(id: number): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.apiServerUrl}/feedback/get/${id}`);
  }
  public createFeedBack(feed:any,idSuvey:any)
  
  {

    return this.http.post(`${this.apiServerUrl}/feedback/create/${idSuvey}`,feed)
  }
  
}
