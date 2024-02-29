import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { QuestionService } from 'app/Services/question.service';
import { SurveyService } from 'app/Services/survey.service';
import { error } from 'console';

@Component({
  selector: 'app-add-survey',
  templateUrl: './add-survey.component.html',
  styleUrls: ['./add-survey.component.scss']
})
export class AddSurveyComponent implements OnInit {
  questions:any;
  formData: any = {};
  

  constructor(private questionService:QuestionService,private surveyService :SurveyService,private _router:Router) { 
   
  }

  ngOnInit(): void {
    this.loadQuestions();
    
   
    
    
  }
  onSubmit(form: NgForm) {
    //const questionId=this.formData.
    //console.log(this.formData);
    const modifiedRequestBody = Object.keys(this.formData).map(key => {
      const [questionId, option] = key.split('.'); // Split the key to get questionId and option
      return {
        questionId: questionId.replace('question-', ''), // Extract the questionId
        optionSelected: option.replace('option', '') // Extract the optionSelected
      };
    });
    
    console.log(modifiedRequestBody);
    if(modifiedRequestBody.length > 0) {
      this.surveyService.insertSurvey(modifiedRequestBody).subscribe((res:any)=>{
        console.log(res)
        this.resetForm();
        this._router.navigate(['/Feedback/addFeed/',res]);
     },error =>{
       console.log(error)
     })
    }
    else {
      alert('you must fill these questions ')
    }
   
  }
  loadQuestions(){
    this.questionService.getAllQuestions().subscribe((res:any)=>{
      this.questions=res;
      console.log(res)
    },error =>{
      console.log(error)
    })
    
  }
  resetForm(){
    this.formData={}

  }
  
  

}
