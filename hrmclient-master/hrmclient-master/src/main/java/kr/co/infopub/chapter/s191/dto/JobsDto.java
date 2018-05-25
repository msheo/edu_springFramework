package kr.co.infopub.chapter.s191.dto;

public class JobsDto {
	private String job_id;
	private String job_title;
	public JobsDto() {
		super();
	}
	public JobsDto(String job_id, String job_title) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
	}
	@Override
	public String toString() {
		return "JobsDto [job_id=" + job_id + ", job_title=" + job_title + "]";
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	
}
