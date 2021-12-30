import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {DawgService} from '../service/dawg.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dawg-form',
  templateUrl: './dawg-form.component.html',
  styleUrls: ['./dawg-form.component.css']
})
export class DawgFormComponent implements OnInit {
  selected:any;
  opc:any;
  benefit: any;
  dawg_FLW_UP: any;
  dawg_ready_for_dba_review: any;
  kanban_state: any;
  panelOpenState = true;
  myFiles:string [] = [];
  fileLink: any = [];
  loader: boolean = false;

  analytics: any[] = [
    {data: 'I need a new Application ID, or an update to my existing Application ID for the Enterprise Data Warehouse (EDW)'},
    {data: 'I need new data added to the Enterprise Data Lake (eAtlas),Setup azure infrastructure and consume e-ATLAS data from AMEA.'},
    {data: 'I need new data added to the Enterprise Data Lake (eAtlas)'},
    {data: 'I need new data added to the Enterprise Data Lake (eAtlas)'},
    {data: 'I am a ePR View user and would like to request an enhancement to the application'},
    {data: 'I need new data added to the Enterprise Data Lake (eAtlas)'},
    {data: 'I need a new Application ID, or an update to my existing Application ID for MarketView'},
    {data: 'Need a NPE Azure environment Setup'},
    {data: 'Modify our AWE cluster'},
    {data: 'I need a new subscription created to ingest pub sub topics'},
    {data: 'I need new data added to the Enterprise Data Lake (eAtlas),Azure Sandbox environment'},
    {data: 'Separate cluster for GL data'},
    {data: 'Quote Letter'},
    {data: 'I need new data added to the Enterprise Data Lake (eAtlas)'},
    {data: 'I need business logic/aggregations applied to existing data'},
    {data: 'I need a new Application ID, or an update to my existing Application ID for the Enterprise Data Lake (eAtlas)'},
    {data: 'I need new data added to the Enterprise Data Warehouse (EDW),modifying sl05 load view'},
    {data: 'My team has a need to schedule jobs on the ORSA AWE using the Service Principal'},
    {data: 'I am a DRIVE user and would like to request an enhancement to the application'},
    {data: 'I need new data added to MarketView'},
    {data: 'I need a new Application ID, or an update to my existing Application ID for the Enterprise Data Lake (eAtlas)","Request for service principle'},
    {data: 'I need new data added to the Enterprise Data Warehouse (EDW)'},
    {data: 'I need new data added to MarketView'},
    {data: 'Need logic changes in the EDW processes that post eDD data to ensure that all pricing data is removed before posting new pricing for given Cust Grp ID & OpCo'},
    {data: 'I need a new Application ID, or an update to my existing Application ID for the Enterprise Data Lake (eAtlas)'},
    {data: 'I need new data added to the Enterprise Data Warehouse (EDW)'},
    {data: 'I need help identifying the tracking numbers currently stored in SmartPost Shipping Tables'},
    {data: 'I need to have a specific cluster configuration available to the ORSA AWE.'},
    {data: 'I need to access data located in Fxsdawsandbox2098206 from my ORSA AWE.'},
    {data: 'I need to have Koalas 1.7.0 & Follium 0.11.0 to be installed on the ORSA AWE.'},
    {data: 'Requesting AWE licenses for our Development Team'},
    {data: 'I need new data added to the Enterprise Data Lake (eAtlas)'},
    {data: 'I need temporary access to an Analytics Workspace Environment (AWE),I have a federated cloud solutions and need data ingestion consulting'},
    {data: 'Enterprise Data Lake Access Request'},
    {data: 'I need support for EDTW'},
    {data: 'I need temporary access to an Analytics Workspace Environment (AWE)'},
    {data: 'I need to have Scala available in Databricks in the ORSA`s AWE.'},
    {data: 'I need the ORSA AWE to have DBFS.'},
    {data: 'EDW'},
    {data: 'I need the EDTW model in the prod environment within the IT Azure sub updated.'},
    {data: 'I need temporary access to an Azure Workspace Environment (AWE)'},
    {data: 'MarketView'},
    {data: 'Big Data â€“ Cloud/Data Lake'},
    {data: 'Analytics â€“ AI/ML-ML Ops'},
    {data: 'Data ingestion to eAtlas'},
    {data: 'Scan Data Lake access in Azure'},
    {data: 'Enterprise Ingestion Framework (EIF)'},
    {data: 'Customer Experience Analytics'},
    {data: 'MarketView â€“ Spot Escalation'},
    {data: 'Analytics â€“ Data Engineering, Big Data â€“ Cloud'},
    {data: 'Big Data â€“ Cloud'},
    {data: 'MarketView â€“ iLoyalty'}
  ];
  
  dawgCreateForm = new FormGroup({
    title        : new FormControl('', [Validators.required]),
    ppmProjectId : new FormControl('', [Validators.required]),
    dataAnalytics: new FormControl('', [Validators.required]),
    need_by_time : new FormControl('', [Validators.required]),
    need_by_rationalization: new FormControl('', [Validators.required]),
    dawg_follow_up_questions : new FormControl(''),
    dawg_recommendation : new FormControl(''),
    dawg_cross_reference : new FormControl(''),
    dawg_additional_comments : new FormControl(''),
    dawg_FLW_UP : new FormControl(''),
    dawg_ready_for_dba_review : new FormControl(''),
    kanban_state : new FormControl(''),
    detailed_desc: new FormControl('', [Validators.required]),
    purpose      : new FormControl('', [Validators.required]),
    acceptance_criteria : new FormControl('', [Validators.required]),
    data_source  : new FormControl('', [Validators.required]),
    business_contact: new FormControl('', [Validators.required]),
    req_managing_director : new FormControl('', [Validators.required]),
    technical_contact: new FormControl('', [Validators.required]),
    completed_first_id : new FormControl('', [Validators.required]),
    impactedOpc  : new FormControl('', [Validators.required]),
    valueBenefit : new FormControl('', [Validators.required]),
    plus_member : new FormControl(''),
    submitted_date : new FormControl(''), // System Date
    attachments : new FormControl('')
    
  })
  
  ImpactedOpcs: string[] = ['FXS', 'FXE', 'FXG', 'FXF', 'FXC', 'FXO'];
  benefits: string[] = ['Increased productivity', 'Enables other functionality or dependency','Cost reduction',
                      'Replaces or retires applications/processes', 'Improves/Enhances Customer Experience',
                    'Legal/Regulatory/Compliance', 'Adoption Enablement', 'Other'];
  today: any = new Date();
  tommorowDate: any = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
  urls:string[] = [];
  selectedFile: any;
  postData: any;
  resObj: any;
  fd: any;
  constructor(private http: HttpClient, public dawgService:DawgService,
    private router: Router) { }
  
  ngOnInit(): void {
    
  }

  gettodayDate(dateConvert: any){
    console.log(dateConvert);
    var dd = String(dateConvert.getDate()).padStart(2, '0');
    var mm = String(dateConvert.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = dateConvert.getFullYear();
    //this.today = mm + '/' + dd + '/' + yyyy;
    return mm + '/' + dd + '/' + yyyy;
  }

  submitForm(){
    this.loader = true;
    var formData: any = new FormData();
    this.dawgCreateForm.value.submitted_date = this.gettodayDate(this.today);
    this.dawgCreateForm.value.need_by_time = this.gettodayDate(this.dawgCreateForm.value.need_by_time);
    //this.dawgCreateForm.value.attachments = this.myFiles;

    // formData.append("title", this.dawgCreateForm.get('title')?.value);
    // formData.append("ppmProjectId", this.dawgCreateForm.get('ppmProjectId')?.value);
    // formData.append("dataAnalytics", this.dawgCreateForm.get('dataAnalytics')?.value);
    // formData.append("need_by_time", this.dawgCreateForm.get('need_by_time')?.value);
    // formData.append("need_by_rationalization", this.dawgCreateForm.get('need_by_rationalization')?.value);
    // formData.append("dawg_follow_up_questions", this.dawgCreateForm.get('dawg_follow_up_questions')?.value);
    // formData.append("dawg_recommendation", this.dawgCreateForm.get('dawg_recommendation')?.value);
    // formData.append("dawg_cross_reference", this.dawgCreateForm.get('dawg_cross_reference')?.value);
    // formData.append("dawg_additional_comments", this.dawgCreateForm.get('dawg_additional_comments')?.value);
    // formData.append("dawg_FLW_UP", this.dawgCreateForm.get('dawg_FLW_UP')?.value);
    // formData.append("dawg_ready_for_dba_review", this.dawgCreateForm.get('dawg_ready_for_dba_review')?.value);
    // formData.append("kanban_state", this.dawgCreateForm.get('kanban_state')?.value);
    // formData.append("detailed_desc", this.dawgCreateForm.get('detailed_desc')?.value);
    // formData.append("purpose", this.dawgCreateForm.get('purpose')?.value);
    // formData.append("acceptance_criteria", this.dawgCreateForm.get('acceptance_criteria')?.value);
    // formData.append("data_source", this.dawgCreateForm.get('data_source')?.value);
    // formData.append("business_contact", this.dawgCreateForm.get('business_contact')?.value);
    // formData.append("req_managing_director", this.dawgCreateForm.get('req_managing_director')?.value);
    // formData.append("technical_contact", this.dawgCreateForm.get('technical_contact')?.value);
    // formData.append("completed_first_id", this.dawgCreateForm.get('completed_first_id')?.value);
    // formData.append("impactedOpc", this.dawgCreateForm.get('ImpactedOpc')?.value);
    // formData.append("valueBenefit", this.dawgCreateForm.get('valueBenefit')?.value);
    // formData.append("plus_member", this.dawgCreateForm.get('plus_member')?.value);
    // formData.append("submitted_date", this.dawgCreateForm.get('submitted_date')?.value);
    // formData.append("attachments", this.dawgCreateForm.get('Attachments')?.value);

    //this.dawgCreateForm.value
    
    
     if(this.dawgCreateForm.value.attachments){
       this.onUpload();
      // 
       this.http.post('https://file.io/', this.fd)  
       .subscribe(res => {
         let resobj: any = res;
         if(resobj){
           this.fileLink.push(resobj.link);
           this.dawgCreateForm.value.attachments = this.fileLink;
            console.log("this.fileLink", this.fileLink);
            console.log("this.dawgCreateForm.value.attachments", this.dawgCreateForm.value.attachments);
            this.dawgService.postdawg(this.dawgCreateForm.value).subscribe(
              data => this.resObj = data
            )
            this.loader = false;
            this.dawgCreateForm.reset();
            this.router.navigate(['/dawgList']);
         }
       })
      //  
      
      }else{
        this.dawgService.postdawg(this.dawgCreateForm.value).subscribe(
          data => this.resObj = data
         
        )
        this.loader = false;
        this.dawgCreateForm.reset();
            this.router.navigate(['/dawgList']);
      }
        
      
       //if(this.fileLink.length != 0){
        
       
        
       //}
    
      // this.dawgService.postdawg(this.dawgCreateForm.value).subscribe(
      //   data => {this.postData = JSON.stringify(this.dawgCreateForm)}
      // )
    
   
  }

 

  onSelectFile(event:any) {
    this.selectedFile = [];
    if (event.target.files && event.target.files[0]) {
     // this.selectedFile = <File> event.target.files[0];
        var filesAmount = event.target.files.length;
        for (let i = 0; i < filesAmount; i++) {
          
          var ext = event.target.files[i].name.split('.').pop();
          if(ext=="pdf" || ext=="docx" || ext=="doc" || ext == ".xls" || ext == ".xlsx" || ext == ".txt"
          || ext=="ppt" || ext=="pptx"){
                var reader = new FileReader();
                reader.onload = (event:any) => {
                this.urls.push(event.target.result); 
                }
                console.log('event.target.files[i].name', event.target.files[i]);
                this.selectedFile.push(event.target.files[i]);
                this.myFiles.push(event.target.files[i].name);
                reader.readAsDataURL(event.target.files[i]);
              }else{
                console.log('WRONG', event.target.files[i]);
              }
        }
        
    }
  }

  onUpload(){
    const fds = new FormData();
    console.log('this.selectedFile', this.selectedFile);
    for (let i = 0; i < this.selectedFile.length; i++) {
       console.log('this.selectedFile', this.selectedFile);
          fds.append('file', this.selectedFile[i], this.selectedFile[i].name)
       // fd.append('file', this.selectedFile, this.selectedFile.name)
          this.fd = fds;
         // this.uploadFiles(fd)
          //https://ufile.io/, https://file.io/ // multiple files
         
  }
  }
  
  //uploadFiles(fd:any){
  
    // this.http.post('https://file.io/', fd)  
    // .subscribe(res => {
    //   let resobj: any = res;
    //   if(resobj){
    //     this.fileLink.push(resobj.link);
        
    //   }
    // })
  //}
 
}
