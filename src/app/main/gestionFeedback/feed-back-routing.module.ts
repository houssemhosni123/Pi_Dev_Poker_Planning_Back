import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FeedBacksComponent } from './feed-backs/feed-backs.component';
import { SurveysComponent } from './surveys/surveys.component';
import { QuestionsComponent } from './questions/questions.component';
import { AjoutComponentComponent } from './ajout-component/ajout-component.component';

import { AddSurveyComponent } from './add-survey/add-survey.component';
import { FeedbackfrontComponent } from './feedbackfront/feedbackfront.component';


const routes: Routes = [
  {path:'',component:FeedBacksComponent},
  {path:'survey',component:SurveysComponent},
  {path:'question',component:QuestionsComponent},

  {path:'addQuestion',component:AjoutComponentComponent},
  {path:'addFeed/:id',component:FeedbackfrontComponent},
  {path:'addSurvey/:id',component:AddSurveyComponent},
  
  

 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeedBackRoutingModule { }