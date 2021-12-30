package com.atos.dawg.model;

import javax.persistence.*;

@Entity
@Table(name = "Unified_list")
public class DawgModel {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long formId;
		
		@Column(name = "request_title")
		private String title;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		@Column(name = "attachments")
		private String[] attachments;

		@Column(name = "data_analyticsneeds")
		private String dataAnalytics;

		@Column(name = "ppm_projectid")
		private String ppmProjectId;
		
		
		@Column(name = "form_submittedby")
		private String form_submittedby;
		
		@Column(name = "needby_timeframe")
		private String need_by_time;
		
		@Column(name = "needby_rationalization")
		private String need_by_rationalization;
		
		@Column(name = "dawg_followup_questions")
		private String dawg_follow_up_questions;
		
		
		@Column(name = "dawg_recommendation")
		private String dawg_recommendation;
		
		
		@Column(name = "dawg_crossreference")
		private String dawg_cross_reference;
		
		
		@Column(name = "dawg_additional_comments")
		private String dawg_additional_comments;
		
		@Column(name = "kanban_state")
		private String kanban_state;
		
		@Column(name = "detailed_description")
		private String detailed_desc;
		
		@Column(name = "purpose")
		private String purpose;
		
		@Column(name = "acceptance_criteria")
		private String acceptance_criteria;
		
		@Column(name = "data_source")
		private String data_source;
		
		@Column(name = "business_contact")
		private String business_contact;
		
		@Column(name = "requestors_md")
		private String req_managing_director;
		
		@Column(name = "technical_contact")
		private String technical_contact;
		
		@Column(name = "impacted_opco")
		private String[] ImpactedOpc;
		
		@Column(name = "benefit")
		private String[] valueBenefit;
		
		@Column(name = "submitted_date")
		private String submitted_date;
		
		@Column(name = "dawg_flwup")
		private String dawg_FLW_UP;
		
		@Column(name = "dawgready_review")
		private String dawg_ready_for_dba_review;
		
		@Column(name = "partner_member_flg")
		private String plus_member;
		
		@Column(name = "modified_on")
		private String modified_on;
		
		@Column(name = "modifier_name")
		private String modifier_name;
		
		@Column(name = "completed_firstid")
		private String completed_first_id;
		
		public DawgModel() {

		}

		public DawgModel(long formId, String title,String[] attachments, String dataAnalytics,String ppmProjectId,String form_submittedby,String need_by_time,String need_by_rationalization,String dawg_follow_up_questions,String dawg_recommendation,String dawg_cross_reference,String dawg_additional_comments,String kanban_state,String detailed_desc,String purpose,String acceptance_criteria,String data_source,String business_contact,String req_managing_director,String technical_contact,String[] ImpactedOpc,String[] valueBenefit,String submitted_date,String dawg_FLW_UP,String dawg_ready_for_dba_review,String plus_member,String modified_on,String modifier_name,String completed_first_id) {
			this.formId = formId;
			this.title = title;
			this.attachments = attachments;
			this.dataAnalytics = dataAnalytics;
			this.ppmProjectId = ppmProjectId;
			//this.request_title = request_title;
			this.form_submittedby = form_submittedby;
			this.need_by_time = need_by_time;
			this.need_by_rationalization = need_by_rationalization;
			this.dawg_follow_up_questions = dawg_follow_up_questions;
			this.dawg_recommendation = dawg_recommendation;
			this.dawg_cross_reference = dawg_cross_reference;
			this.dawg_additional_comments = dawg_additional_comments;
			this.kanban_state = kanban_state;
			this.detailed_desc = detailed_desc;
			this.purpose = purpose;
			this.acceptance_criteria = acceptance_criteria;
			this.data_source = data_source;
			this.business_contact = business_contact;
			this.req_managing_director = req_managing_director;
			this.technical_contact = technical_contact;
			this.ImpactedOpc = ImpactedOpc;
			this.valueBenefit = valueBenefit;
			this.submitted_date = submitted_date;
			this.dawg_FLW_UP = dawg_FLW_UP;
			this.dawg_ready_for_dba_review = dawg_ready_for_dba_review;
			this.plus_member = plus_member;
			this.modified_on = modified_on;
			this.modifier_name = modifier_name;
			this.completed_first_id = completed_first_id;
			
			
		}

		public long getFormId() {
			return formId;
		}

		public void setFormId(long formId) {
			this.formId = formId;
		}

		public String[] getAttachments() {
			return attachments;
		}

		public void setAttachments(String[] attachments) {
			this.attachments = attachments;
		}

		public String getDataAnalytics() {
			return dataAnalytics;
		}

		public void setDataAnalytics(String dataAnalytics) {
			this.dataAnalytics = dataAnalytics;
		}

		public String getPpmProjectId() {
			return ppmProjectId;
		}

		public void setPpmProjectId(String ppmProjectId) {
			this.ppmProjectId = ppmProjectId;
		}

		public String getForm_submittedby() {
			return form_submittedby;
		}

		public void setForm_submittedby(String form_submittedby) {
			this.form_submittedby = form_submittedby;
		}

		public String getNeed_by_time() {
			return need_by_time;
		}

		public void setNeed_by_time(String need_by_time) {
			this.need_by_time = need_by_time;
		}

		public String getNeed_by_rationalization() {
			return need_by_rationalization;
		}

		public void setNeed_by_rationalization(String need_by_rationalization) {
			this.need_by_rationalization = need_by_rationalization;
		}

		public String getDawg_follow_up_questions() {
			return dawg_follow_up_questions;
		}

		public void setDawg_follow_up_questions(String dawg_follow_up_questions) {
			this.dawg_follow_up_questions = dawg_follow_up_questions;
		}

		public String getDawg_recommendation() {
			return dawg_recommendation;
		}

		public void setDawg_recommendation(String dawg_recommendation) {
			this.dawg_recommendation = dawg_recommendation;
		}

		public String getDawg_cross_reference() {
			return dawg_cross_reference;
		}

		public void setDawg_cross_reference(String dawg_cross_reference) {
			this.dawg_cross_reference = dawg_cross_reference;
		}

		public String getDawg_additional_comments() {
			return dawg_additional_comments;
		}

		public void setDawg_additional_comments(String dawg_additional_comments) {
			this.dawg_additional_comments = dawg_additional_comments;
		}

		public String getKanban_state() {
			return kanban_state;
		}

		public void setKanban_state(String kanban_state) {
			this.kanban_state = kanban_state;
		}

		public String getDetailed_desc() {
			return detailed_desc;
		}

		public void setDetailed_desc(String detailed_desc) {
			this.detailed_desc = detailed_desc;
		}

		public String getPurpose() {
			return purpose;
		}

		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}

		public String getAcceptance_criteria() {
			return acceptance_criteria;
		}

		public void setAcceptance_criteria(String acceptance_criteria) {
			this.acceptance_criteria = acceptance_criteria;
		}

		public String getData_source() {
			return data_source;
		}

		public void setData_source(String data_source) {
			this.data_source = data_source;
		}

		public String getBusiness_contact() {
			return business_contact;
		}

		public void setBusiness_contact(String business_contact) {
			this.business_contact = business_contact;
		}

		public String getReq_managing_director() {
			return req_managing_director;
		}

		public void setReq_managing_director(String req_managing_director) {
			this.req_managing_director = req_managing_director;
		}

		public String getTechnical_contact() {
			return technical_contact;
		}

		public void setTechnical_contact(String technical_contact) {
			this.technical_contact = technical_contact;
		}

		public String[] getImpactedOpc() {
			return ImpactedOpc;
		}

		public void setImpactedOpc(String[] ImpactedOpc) {
			this.ImpactedOpc = ImpactedOpc;
		}

		public String[] getValueBenefit() {
			return valueBenefit;
		}

		public void setValueBenefit(String[] valueBenefit) {
			this.valueBenefit = valueBenefit;
		}

		public String getSubmitted_date() {
			return submitted_date;
		}

		public void setSubmitted_date(String submitted_date) {
			this.submitted_date = submitted_date;
		}

		public String getDawg_FLW_UP() {
			return dawg_FLW_UP;
		}

		public void setDawg_FLW_UP(String dawg_FLW_UP) {
			this.dawg_FLW_UP = dawg_FLW_UP;
		}

		public String getDawg_ready_for_dba_review() {
			return dawg_ready_for_dba_review;
		}

		public void setDawg_ready_for_dba_review(String dawg_ready_for_dba_review) {
			this.dawg_ready_for_dba_review = dawg_ready_for_dba_review;
		}

		public String getPlus_member() {
			return plus_member;
		}

		public void setPlus_member(String plus_member) {
			this.plus_member = plus_member;
		}

		public String getModified_on() {
			return modified_on;
		}

		public void setModified_on(String modified_on) {
			this.modified_on = modified_on;
		}

		public String getModifier_name() {
			return modifier_name;
		}

		public void setModifier_name(String modifier_name) {
			this.modifier_name = modifier_name;
		}

		public String getCompleted_first_id() {
			return completed_first_id;
		}

		public void setCompleted_first_id(String completed_first_id) {
			this.completed_first_id = completed_first_id;
		}

		@Override
		public String toString() {
			return "DawgModel [formId=" + formId + ", title=" + title + ", attachments=" + attachments + ", dataAnalytics=" + dataAnalytics + ", ppmProjectId=" + ppmProjectId + ", form_submittedby=" + form_submittedby + ", need_by_time=" + need_by_time + ", need_by_rationalization=" + need_by_rationalization + ", dawg_follow_up_questions=" + dawg_follow_up_questions + ", dawg_recommendation=" + dawg_recommendation + ", dawg_cross_reference=" + dawg_cross_reference + ", dawg_additional_comments=" + dawg_additional_comments + ", kanban_state=" + kanban_state + ", detailed_desc=" + detailed_desc + ", purpose=" + purpose + ", acceptance_criteria=" + acceptance_criteria + ", data_source=" + data_source + ", business_contact=" + business_contact + ", req_managing_director=" + req_managing_director + ", technical_contact=" + technical_contact + ", ImpactedOpc=" + ImpactedOpc + ", valueBenefit=" + valueBenefit + ", submitted_date=" + submitted_date + ", dawg_FLW_UP=" + dawg_FLW_UP + ", dawg_ready_for_dba_review=" + dawg_ready_for_dba_review + ", plus_member=" + plus_member + ", modified_on=" + modified_on + ", modifier_name=" + modifier_name + ", completed_first_id=" + completed_first_id +"]";
		}
}


