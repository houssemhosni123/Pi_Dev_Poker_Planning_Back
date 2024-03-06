import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from 'app/Model/Feedback';
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
public createFeedBack(feed: any, idSuvey: any): Observable<any> {
  return this.http.post(`${this.apiServerUrl}/feedback/create`, feed);
}

  public calculateAverageEvaluationBySessionId(sessionid: number): Observable<number> {
    return this.http.get<number>(`${this.apiServerUrl}/feedback/calculateAverageEvaluation/${sessionid}`);
  }
  
}
