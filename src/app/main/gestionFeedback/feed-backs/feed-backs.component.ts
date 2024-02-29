import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ColumnMode,DatatableComponent } from '@swimlane/ngx-datatable';
import { Feedback } from 'app/Feedback';
import { FeedbackService } from 'app/Services/feedback.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-feed-backs',
  templateUrl: './feed-backs.component.html',
  styleUrls: ['./feed-backs.component.scss']
})
export class FeedBacksComponent implements OnInit {

  feedbacks:any;
  public data: any;
  public selectedOption = 10;
  public ColumnMode = ColumnMode;
  public selectStatus: any = [
    { name: 'All', value: '' },
    { name: 'Downloaded', value: 'Downloaded' },
    { name: 'Draft', value: 'Draft' },
    { name: 'Paid', value: 'Paid' },
    { name: 'Partial Payment', value: 'Partial Payment' },
    { name: 'Past Due', value: 'Past Due' },
    { name: 'Sent', value: 'Sent' }
  ];

  public selectedStatus = [];
  public searchValue = '';

  // decorator
  @ViewChild(DatatableComponent) table: DatatableComponent;

  // private
  private tempData = [];
  private _unsubscribeAll: Subject<any>;
  public rows;
  public tempFilterData;
  public previousStatusFilter = '';

  constructor(private feedbackService: FeedbackService,private router:Router) { }

  ngOnInit(): void {
    this.loadFeedBack();
  }

  loadFeedBack() {
    this.feedbackService.getAllFeedbacks().subscribe((res: any) => {
      this.rows=res;
      this.feedbacks = res;
      console.log(res);
    }, error => {
      console.log(error);
    });
  }

  deleteFeedback(row: Feedback) {
    if (confirm('Are you sure you want to delete this feedback?')) {
      this.feedbackService.deleteFeedbackById(row.idfeedback).subscribe(() => {
        this.feedbacks = this.feedbacks.filter((feedback: Feedback) => feedback.idfeedback !== row.idfeedback);
        console.log("Feedback deleted successfully");
      }, error => {
        console.error("Error deleting feedback:", error);
      });
    }
  }


  filterUpdate() {
    if (this.searchValue) {
      const searchId = Number(this.searchValue);
      this.rows = this.feedbacks.filter((f: any) => f.idfeedback === searchId);
      console.log(this.rows)
    } else {
      this.rows = [...this.feedbacks];
    }
  }
 // Define `toggleSurvey` method in your component class
toggleSurvey(row: any) {


//this.router.navigate(['/detail/',row.idfeedback]);
}

  

  filterByStatus($event) {
  }

}
